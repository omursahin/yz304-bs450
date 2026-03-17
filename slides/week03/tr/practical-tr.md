# Daha İyi Birim Testi

`code` dizininde bulunan
[`eru.testing.forum`](../../apps/src/main/eru/testing/forum/)
paketi; kullanıcıları ve gönderileri olan bir çevrimiçi forumu temsil eder.
Bu yönleri temsil eden üç sınıf vardır:
[`Forum`](../../apps/src/main/eru/testing/forum/Forum.java),
[`User`](../../apps/src/main/eru/testing/forum/User.java) ve
[`Post`](../../apps/src/main/eru/testing/forum/Post.java).

[`ForumTest`](../../apps/src/main/eru/testing/forum/ForumTest.java)
sınıfı, `Forum` sınıfını test etmek için vardır. Ancak testlerde bazı sorunlar
bulunmaktadır:

* Olası kırılganlık
* Netlik eksikliği
* Özlü olmama
* Davranış yerine implementasyonun test edilmesine odaklanma

## Yapmanız Gerekenler

`ForumTest` içindeki her testi ele alın. Derste öğrendiklerinize göre:

1. Her testteki olası sorunları belirleyin ve neden sorun olduğunu/olabileceğini açıklayın.
2. Belirlediğiniz sorunları kaldıracak şekilde testi yeniden yazın.
3. (1) maddesinde yazdığınız ölçütlere göre testinizi gözden geçirin ve ilk belirlediğiniz sorunları giderdiğinizden emin olun.
