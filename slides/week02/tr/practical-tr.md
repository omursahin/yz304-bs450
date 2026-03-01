# Hafta 2 Uygulama – Kusurlar, Enfeksiyonlar ve Başarısızlıklar (Defects, Infections and Failures)

Bu uygulama, bu deponun kod dizininde bulunan Maven projesinin bir parçası olan `DIF.java` sınıfını içermektedir. Bkz.
[`apps/src/main/eru/testing/DIF.java`](../../apps/src/main/eru/testing/DIF.java).

Sınıf dört metot içermektedir: `findLast`, `countPositive`, `lastZero` ve `oddOrPos`.

Her metodun bir kusuru (defect) bulunmaktadır. Her kusur için JUnit testleri yazmanız ve düzeltmeyi belirlemeniz gerekmektedir.

Özellikle, `DIF.java` dosyasındaki her metot için aşağıdaki görevleri tamamlamanız gerekmektedir. Yazacağınız testler `DIFTest.java` adlı bir sınıfa eklenmelidir. (Not: Testleri adlandırırken `[metodAdı]` kısmı, testini yazdığınız metodun adıyla değiştirilmelidir.)

1. (a) Kusur nedir ve nerededir?

   (b) Hangi koşul(lar) altında metoda verilen girdiler başarısızlığa neden olur?

   (c) Metodun başarısız olmasına neden olan BİR adet JUnit test durumu yazın.
   Bu test `[metodAdı]_failure` olarak adlandırılmalıdır. (Testin de başarısız olması gerektiğini unutmayın - yani test, metodun _doğru_ davranışı için bir doğrulama (assertion) içermelidir.)

2. (a) Metoda verilen girdilerin kusuru _çalıştırmaması_ mümkün müdür? Eğer mümkünse, bunun gerçekleşmesi için metoda verilen girdilerin sağlaması gereken koşul(lar)ı açıklayın.

   (b) Eğer mümkünse (bu sorunun (a) şıkkına verdiğiniz cevaba göre), bu sorunun (a) şıkkında açıklanan senaryoyu gösteren bir JUnit test durumu yazın.
   Bu test `[metodAdı]_defectNotExecuted` olarak adlandırılmalıdır.

3. (a) Bir girdinin kusuru çalıştırması ancak programın durumunu _enfekte etmemesi_ (bozmamamsı) mümkün müdür? Eğer mümkünse, bunun gerçekleşmesi için metoda verilen girdilerin sağlaması gereken koşul(lar)ı açıklayın.

   (b) Eğer mümkünse (bu sorunun (a) şıkkına verdiğiniz cevaba göre), bu sorunun (a) şıkkında açıklanan senaryoyu gösteren bir JUnit test durumu yazın.
   Bu test `[metodAdı]_defectExecuted_noInfection` olarak adlandırılmalıdır.

4. (a) Bir girdinin enfeksiyona neden olması ancak metodun _başarısız olmaması_ mümkün müdür? (Not: çalıştırılmaması gereken program ifadelerinin çalıştırılması da enfeksiyon sayılır.) Eğer mümkünse, bunun gerçekleşmesi için metoda verilen girdilerin sağlaması gereken koşul(lar)ı açıklayın.

   (b) Eğer mümkünse (bu sorunun (a) şıkkına verdiğiniz cevaba göre), bu sorunun (a) şıkkında açıklanan senaryoyu gösteren bir JUnit test durumu yazın.
   Bu test `[metodAdı]_defectExecuted_infectionCaused_noFailure` olarak adlandırılmalıdır.

5. Kusuru düzeltin ve düzeltilmiş metodu `DIFFixed.java` adlı bir sınıfa ekleyin. (Soru 1 kapsamında yazdığınız testin, metodun düzeltilmiş sürümüyle çalıştırıldığında başarılı olduğundan emin olun.)
