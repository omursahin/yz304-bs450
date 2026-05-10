# Fuzzing – Pratik Oturum

Bu oturumda basit bir Java programı için ilk fuzzer'ımızı geliştireceğiz.

## Hedef Java Programı

Önce fuzz uygulayacağımız çok basit bir Java programı yazarak başlıyoruz.

`Greeting.java` adında, içinde `main` metodu bulunan tek bir public sınıf (`Greeting`) içeren yeni bir Java programı oluşturun.

`main` metodu içinde aşağıdaki şartnameye uyan bir program yazın:

- Program konsola `"What is your name?"` yazdırarak başlar.
- Program kullanıcıdan bir string girdi alır; bunun için bir [Scanner](https://www.w3schools.com/java/java_user_input.asp) nesnesi kullanabilirsiniz.
- Program girdiyi şu şekilde doğrular:
  - Girdi boşsa bir `IllegalArgumentException` fırlatılmalıdır.
  - İsimler için `BUFFER_SIZE=20` adında bir maksimum uzunluk olduğunu varsayın; girdi bu sınırdan uzunsa bir `BufferOverflowException` fırlatılmalıdır.
  - Bir isimde garip karakterlere izin verilmez. Girdinin şu desende geçen karakterlerden birini içerip içermediğini kontrol etmek için [pattern matching](https://www.w3schools.com/java/java_regex.asp) kullanın: `"[!@#$%&*()_+=|<>?{}\\[\\]~-]"`. Girdi bu karakterlerden herhangi birini içeriyorsa bir `IllegalArgumentException` fırlatılmalıdır.
- Son olarak, geçerli isim ile birleştirilmiş bir karşılama mesajını konsola yazdırın, örn. `"Hi there, "` + isim.

Bu adımı bitirdikten sonra Java programınızı `javac Greeting.java` ile derleyin.

Bu komut hata veriyorsa ya kodda hata yapmışsınızdır ya da makinenizde Java kurulu değildir. `javac --version` komutunun çıktısını kontrol edin.

Ardından `java Greeting` komutunu çalıştırıp isminizi girdi olarak vererek hızlı bir test yapın – Program sizi karşılıyor mu? Harika!

## Java Fuzzer

Basit Java fuzzer'ımızı kolaylık olsun diye Python ile yazacağız. Tercih ettiğiniz başka bir programlama diliyle de yapabilirsiniz.

`jfuzzer.py` adında bir Python script'i oluşturarak başlayalım.

### Python'dan Java Programı Çalıştırma

Fuzzing _dinamik_ bir test tekniğidir, yani test edilen programın çalıştırılması gerekir. Bu yüzden bir programı ve parametrelerini alıp onu alt süreç (subprocess) olarak çalıştırabilen bir fonksiyon yazmamız gerekiyor.

Bu aşamada hatırlanması gereken en önemli tek şey şudur: fuzzer programı çalıştırmalı ve girdi normal bir çalıştırma da bir çökme de tetiklese çıktısını yakalamalıdır. **Fuzzer asla çökmemelidir!**

İşte basit hedef programımız için işe yarayacak örnek bir fonksiyon.

```python
from subprocess import run, PIPE

def run_program(program, input_string):
    prog_args = []
    execution = run(['java', program] + prog_args, stdout=PIPE, stderr=PIPE, input=input_string.encode("utf-8"))
    return execution
```

`run_program` fonksiyonumuzun, yalnızca tek bir string'i girdi olarak alıp ek argüman almayarak problemi aşırı basitleştirdiğine ve hedef programımıza _aşırı uyduğuna_ (overfit) dikkat edin. Daha karmaşık hedef programları çalıştırabilmek için bu fonksiyonu geliştirmekte özgürsünüz.

Aşağıdaki komutu çalıştırarak `Greeting` Java programını çalıştırabildiğinizi test edebilirsiniz:

```shell
python3 -c "from jfuzzer import run_program; exec = run_program('Greeting', 'Jose'); print(exec.stdout.decode());"
```

### Rastgele String Üretme

Bir fuzzer özünde rastgele girdi üreticisidir.

Aşağıdaki imzaya sahip bir fonksiyon yazın:

```python
def generate_string(min_length=0, max_length=sys.maxsize):
    # mantığınız burada
    return input_string
```

Fonksiyon şunları yapmalıdır:

- Belirli bir alfabe tanımlayın, örn. `alphabet = list("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-!@")`; bu örnek alfabenin küçük ve büyük harfleri, rakamları ve bazı özel karakterleri içerdiğine dikkat edin.
- Üretilecek string için `min_length` ile `max_length` arasında rastgele bir uzunluk seçin, örn. [`random.randint`](https://www.w3schools.com/python/ref_random_randint.asp) kullanarak.
- Bir döngüde, verilen alfabeden örnekleme yaparak gerektiği kadar karakter üretin (örn. [`random.sample`](https://www.w3schools.com/python/ref_random_sample.asp) ile) ve sonuç string'inize ekleyin.
- Sonuç string'ini döndürün.

### Fuzzing Sürücüsü

Hedef programımızı çalıştırabildiğimize ve ona besleyeceğimiz girdi string'lerini üretebildiğimize göre, asıl fuzzing sürücüsünü yazalım. Bu fonksiyonun tanımı şu şekilde olacak:

```python
def fuzzer(program, num_tests, max_length):
    tests = []
    # mantığınız burada
    return tests
```

`fuzzer` fonksiyonunun girdileri test edilen hedef program, çalıştırmak istediğimiz test sayısı ve hedef programa beslenecek girdi string'leri için istediğimiz maksimum uzunluktur.

- Gerektiği kadar test için sırasıyla `generate_string` ve `run_program` fonksiyonlarını çağırın.
- Çalıştırma sonuçlarını bir [dictionary](https://www.w3schools.com/python/python_dictionaries.asp) içinde toplayın; testin id'sini, kullanılan girdiyi ve gözlenen çıktıyı (yani `run_program`'ın döndürdüğünü) içersin.
- Test çalıştırma sonuçlarını bir dizi içinde döndürün.

### Sonuçlar

Son olarak, `fuzzer` metodundan elde edilen çalıştırma sonuçlarını yazdırmak için bir `print_results(tests)` fonksiyonu daha yazın. Bu, fuzzer tarafından çalıştırılan her testi konsola yazdıran basit bir döngü olmalıdır. Önerilen format şöyledir:

```
Test #0:
    IN: jTtAahGSC
    OUT:    0
    CONSOLE:
     What's your name?
     Hi there, jTtAahGSC

Test #1:
    IN: L!peTbT
    OUT:    1
    ERROR:
     Exception in thread "main" java.lang.IllegalArgumentException
        at Greeting.main(Greeting.java:20)
```

`run_program` fonksiyonunun çıktısının [CompletedProcess](https://realpython.com/python-subprocess/#the-completedprocess-object) tipinde olduğuna dikkat edin; bu nesne size bir `returncode` (Java programları için yalnızca normal çalıştırmalarda 0 olur), normal çalıştırmalarda konsola gönderilen çıktıyı içeren `stdout` ve hatalı çalıştırmalarda hata çıktısını içeren `stderr` sağlar.

### `jfuzzer`'ı Çalıştırın!

Ne heyecanlı, ilk fuzzer'ımız hazır!

Gerekli argümanların alındığı (yani hedef program, test sayısı ve girdi string'lerinin maksimum uzunluğu), `fuzzer` fonksiyonunun çağrıldığı ve sonuçlarının yazdırıldığı bir `main` metodu kodlayın.

Test sayısı ve string uzunluğu için farklı değerler deneyin ve sonuçları inceleyin. Fuzzer'ınız Java programındaki problemleri ortaya çıkarabiliyor mu, yani yakalanmamış bir exception ile sonlanan çalıştırmaları?

## Tartışma

Uygulamanızı ve sonuçlarınızı laboratuvarda yanınızda oturan kişiyle tartışın.

Ayrıca fuzzer'ınızı geliştirebileceğiniz farklı yolları da tartışın, örneğin:

- Tamamen rastgele string'ler kullanmak yerine geçerli isimlerden başlayıp [mutasyonlar](https://www.fuzzingbook.org/html/MutationFuzzer.html) uygulamak?
- Test üretimini yönlendirmek için bir [grammar](https://www.fuzzingbook.org/html/Grammars.html) kullanmak?
- Önemsiz `Greetings` programının dışındaki Java programlarını da desteklemek?
- Başka yollar düşünebiliyor musunuz?
