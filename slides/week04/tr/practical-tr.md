# Test Doubles

[`eru.testing.calculator`](../../apps/src/main/java/eru/testing/calculator)
paketine göz atın ve özellikle
[`Calculator`](../../apps/src/main/java/eru/testing/calculator/Calculator.java)
sınıfına dikkat edin.

Bir
[`Reader`](../../apps/src/main/java/eru/testing/calculator/Reader.java)
ve bir
[`Writer`](../../apps/src/main/java/eru/testing/calculator/Writer.java)
ile oluşturulduğunda, `calculate` metodu iki sayı ve bir operatör okur – operatör `+` (toplama),
`-` (çıkarma), `*` (çarpma) veya `/` (bölme) olabilir – ve sonucu yazar. Okuma ve yazma
işlemlerinin kaynakları, `Reader` ve `Writer` arayüzlerinin nasıl uygulandığına göre değişir.

[`CommandLineCalculator`](../../apps/src/main/java/eru/testing/calculator/CommandLineCalculator.java),
`Reader` ve `Writer` arayüzlerini sırasıyla klavyeyi girdi, konsolu ise çıktı olarak kullanacak
şekilde uygular. Deponun `apps` dizininde bir terminal açarak bu örneği derleyip çalıştırabilirsiniz:

```
cd apps
mvn clean compile
java -cp target/classes eru.testing.calculator.CommandLineCalculator
```


Örnek bir çalıştırma aşağıdaki gibi görünür:

```
Enter a number:
500
Enter an operator (+, -, *, or /):
/
Enter a number:
5
500.0 / 5.0 = 100.0
```

## Yapmanız Gerekenler

**Bu alıştırmanın amacı,
[`Calculator`](../../apps/src/main/java/eru/testing/calculator/Calculator.java)
sınıfı için tam kapsama (full coverage) sağlayan bir JUnit test paketi yazmaktır.**

Derslerde gösterildiği gibi, kapsamı JaCoCo ile kontrol edebilirsiniz.
`Reader` ve `Writer` arayüzleri için test double'ları yazmanız gerekecektir. Bunu elle
yapabilir veya Mockito kullanabilirsiniz.

Mockito ile bir stub'ı sırayla farklı değerler döndürecek şekilde ayarlayabileceğinizi
unutmayın, örneğin:

```
when(mock.getGreatestFootballTeams()).thenReturn("Everton", "Sheffield United");
```

Yani `getGreatestFootballTeams()` metodu ilk çağrıldığında `"Everton"`, ikinci kez
çağrıldığında `"Sheffield United"` döndürür. Aynı etkiyi `thenReturn` çağrılarını
zincirleyerek de elde edebilirsiniz:

```
when(mock.getGreatestFootballTeams()).thenReturn("Everton").thenReturn("Sheffield United");
```

Bir stub'ı `thenThrow` ile istisna fırlatacak şekilde yapabilirsiniz, kullanımı şu şekildedir:

```
when(mock.getFootballTeam("Liverpool")).thenThrow(new ObjectionalTeamException());
```

`thenThrow` çağrıları `thenReturn` ile zincirlenebilir.
