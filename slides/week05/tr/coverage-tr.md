# Test Kapsama (Test Coverage)

Geçen haftadan [`eru.testing.forum`](../../apps/src/main/java/eru/testing/forum/)
paketindeki Forum örneğini hatırlayın.

Aşağıdaki komutları çalıştırarak bu örnek için bir JaCoCo kapsama raporu
oluşturun (Windows'ta `./` ön ekine ihtiyacınız olmayabilir). Terminal
kabuğunuzda `app` dizininde olduğunuzdan emin olmanız gerekir:

```
mvn clean install
mvn -Dtest="eru.testing.forum.ForumTest" test
```

`app/` içinde bir `target` dizini ve onun içinde de `target/site/jacoco`
alt dizini oluşmalıdır. Buradan HTML dosyalarını bir web tarayıcısında
açabilirsiniz. Derslerde gösterildiği gibi kod satırlarını yeşil, sarı ve
kırmızı renklerle vurgulayan `ForumTest` için test raporunu bulun.

## Yapmanız Gerekenler

1. Kırmızı renkli her satır için, `ForumTest` tarafından test edilmeyen
   `Forum` __davranışını__ belirleyin.

2. Bu davranış için bir test yazın. Testin `should` ön/son ekine sahip
   olduğundan ve açık bir Given/When/Then yapısına sahip olduğundan emin olun.

3. `ForumTest` için JaCoCo test raporundaki her satır artık yeşil olduğuna
   göre, ek olarak test edebileceğiniz başka davranışlar var mı? Yoksa test
   takımınız tüm olası davranışları test etti mi?

4. `Forum` sınıfının davranışını gerçekten test etmek yerine, kodu yürütmek
   için ne ölçüde test yazdınız?

## Tartışma Soruları

Aşağıdaki soruları bir düşünün ve mümkünse bir ders arkadaşınızla tartışın:

1. Sizce ifade kapsama (statement coverage) pratikte faydalı bir kavram
   mıdır?

2. İfade kapsamanın aşağıdakiler hakkında ne söylediğini düşünüyorsunuz:

   a) kaç tane hata (bug) bulunacağı?

   b) tam kapsama sağlanırsa geriye kaç hata kalacağı?

   c) ne kadar test yapıldığı?

   d) ne zaman test etmeyi bırakmak gerektiği?

2. %100 ifade kapsamanın gerçekçi ve faydalı bir hedef olduğunu düşünüyor
   musunuz?
