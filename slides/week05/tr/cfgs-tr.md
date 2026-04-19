# Kontrol Akış Grafikleri (CFG'ler)

1) [`Triangle`](../../apps/src/main/java/eru/testing/Triangle.java)
   örneğini hatırlayın. `classify` metodu için kontrol akış grafiğini (CFG)
   çizin.

   Derslerde ele almadığımız bir konu, bir istisna (exception) fırlatıldığında
   kontrol akışı açısından ne olduğudur. Grafiğinize, bir istisna
   fırlatıldığında kontrol akışının ne olduğunu düşündüğünüzü dahil edin.

2) [`Calculator`](../../apps/src/main/java/eru/testing/calculator/Calculator.java)
   örneğini hatırlayın. Bu sınıf için sınıf kontrol akış grafiğini (CCFG)
   çizin. Düğümleri ilgili tanımlamaları (definitions) ve kullanımları (uses)
   ile etiketleyin.

   Bir metot aynı sınıftaki başka bir metodu çağırdığında, bu çağrıyı
   CCFG'de o metodun gövdesine ok çizmek yerine, çağıran metodun içinde
   sıradan bir düğüm olarak gösterebilirsiniz.

   Derslerde `try`-`catch` yapılarında istisnalar fırlatıldığında ve
   yakalandığında kontrol akışını ele almadık. Buradaki kontrol akışının
   nasıl olduğunu düşünüyorsunuz?
