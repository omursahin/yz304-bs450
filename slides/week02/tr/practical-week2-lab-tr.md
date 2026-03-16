# Hafta 2 Lab – JUnit 5 Temelleri & DIF Analizi (Bölüm 2)

Bu lab iki bölümden oluşmaktadır. Bölüm A `MathUtils.java` sınıfını, Bölüm B ise
`DIF2.java` sınıfını içermektedir. Her ikisi de bu deponun kod dizininde bulunan Maven
projesinin bir parçasıdır.

## Bölüm A – JUnit 5 Isınma

Bu bölüm `MathUtils.java` sınıfını içermektedir. Bkz.
[`apps/src/main/java/eru/testing/MathUtils.java`](../../apps/src/main/java/eru/testing/MathUtils.java).

Sınıf üç metot içermektedir: `factorial`, `isPrime` ve `gcd`. Bu metotlarda hata
bulunmamaktadır.

`apps/src/test/java/eru/testing/MathUtilsTest.java` dosyasını açın. Bu dosyada
`fail("Test not implemented yet")` yer tutucuları ile 15 test metodu iskeleti bulunmaktadır.
Her `fail(...)` ifadesini Arrange-Act-Assert (AAA) kalıbını takip ederek uygun
doğrulama (assertion) ile değiştirin.

Testleri şu şekilde çalıştırabilirsiniz:

```bash
cd apps
mvn test -Dtest=MathUtilsTest
```

Doğru şekilde yazıldığında 15 testin tamamı başarılı olmalıdır.

## Bölüm B – Kusurlar, Enfeksiyonlar ve Başarısızlıklar (Bölüm 2)

Bu bölüm `DIF2.java` sınıfını içermektedir. Bkz.
[`apps/src/main/java/eru/testing/DIF2.java`](../../apps/src/main/java/eru/testing/DIF2.java).

Sınıf dört metot içermektedir: `findMin`, `countEven`, `isSorted` ve
`firstDuplicate`.

Her metodun bir kusuru (defect) bulunmaktadır. Her kusur için JUnit testleri yazmanız ve
düzeltmeyi belirlemeniz gerekmektedir.

Özellikle, `DIF2.java` dosyasındaki her metot için aşağıdaki görevleri tamamlamanız
gerekmektedir. Yazacağınız testler `DIF2Test.java` adlı bir sınıfa eklenmelidir. (Not:
Testleri adlandırırken `[metodAdı]` kısmı, testini yazdığınız metodun adıyla
değiştirilmelidir.)

1. (a) Kusur nedir ve nerededir?

   (b) Hangi koşul(lar) altında metoda verilen girdiler başarısızlığa neden olur?

   (c) Metodun başarısız olmasına neden olan BİR adet JUnit test durumu yazın.
   Bu test `[metodAdı]_failure` olarak adlandırılmalıdır. (Testin de başarısız olması
   gerektiğini unutmayın - yani test, metodun _doğru_ davranışı için bir doğrulama
   (assertion) içermelidir.)

2. (a) Metoda verilen girdilerin kusuru _çalıştırmaması_ mümkün müdür? Eğer mümkünse,
   bunun gerçekleşmesi için metoda verilen girdilerin sağlaması gereken koşul(lar)ı açıklayın.

   (b) Eğer mümkünse (bu sorunun (a) şıkkına verdiğiniz cevaba göre), bu sorunun (a)
   şıkkında açıklanan senaryoyu gösteren bir JUnit test durumu yazın.
   Bu test `[metodAdı]_defectNotExecuted` olarak adlandırılmalıdır.

3. (a) Bir girdinin kusuru çalıştırması ancak programın durumunu _enfekte etmemesi_
   (bozmaması) mümkün müdür? Eğer mümkünse, bunun gerçekleşmesi için metoda verilen
   girdilerin sağlaması gereken koşul(lar)ı açıklayın.

   (b) Eğer mümkünse (bu sorunun (a) şıkkına verdiğiniz cevaba göre), bu sorunun (a)
   şıkkında açıklanan senaryoyu gösteren bir JUnit test durumu yazın.
   Bu test `[metodAdı]_defectExecuted_noInfection` olarak adlandırılmalıdır.

4. (a) Bir girdinin enfeksiyona neden olması ancak metodun _başarısız olmaması_ mümkün
   müdür? (Not: çalıştırılmaması gereken program ifadelerinin çalıştırılması da enfeksiyon
   sayılır.) Eğer mümkünse, bunun gerçekleşmesi için metoda verilen girdilerin sağlaması
   gereken koşul(lar)ı açıklayın.

   (b) Eğer mümkünse (bu sorunun (a) şıkkına verdiğiniz cevaba göre), bu sorunun (a)
   şıkkında açıklanan senaryoyu gösteren bir JUnit test durumu yazın.
   Bu test `[metodAdı]_defectExecuted_infectionCaused_noFailure` olarak adlandırılmalıdır.

5. Kusuru düzeltin ve düzeltilmiş metodu `DIF2Fixed.java` adlı bir sınıfa ekleyin.
   (Soru 1 kapsamında yazdığınız testin, metodun düzeltilmiş sürümüyle çalıştırıldığında
   başarılı olduğundan emin olun.)
