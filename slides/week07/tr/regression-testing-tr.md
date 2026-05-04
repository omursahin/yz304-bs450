# Regresyon Testi

Aşağıdaki senaryoyu kullanacağız.

Test edilen bir $p$ programının on dalı olduğunu varsayalım, bu dallar $b_1 \ldots b_{10}$ ile gösterilsin.

Ayrıca, altı test durumu içeren bir $T$ regresyon test takımı olduğunu varsayalım, bu test durumları $t_1 \ldots t_6$ olmak üzere şu şekilde tanımlanmış olsun:

- $t_1$ ile yapılan yürütme şu dalların kapsanmasına yol açar: $b_1, b_3, b_7$.
- $t_2$ ile yapılan yürütme şu dalların kapsanmasına yol açar: $b_2, b_5, b_7$.
- $t_3$ ile yapılan yürütme şu dalların kapsanmasına yol açar: $b_1, b_4, b_8, b_{10}$.
- $t_4$ ile yapılan yürütme şu dalların kapsanmasına yol açar: $b_2, b_6, b_9, b_{10}$.
- $t_5$ ile yapılan yürütme şu dalların kapsanmasına yol açar: $b_2, b_5, b_8, b_9, b_{10}$.
- $t_6$ ile yapılan yürütme şu dalların kapsanmasına yol açar: $b_1, b_4, b_7$.

## Test Takımı Minimizasyonu

### Görev 1

1. Yukarıdaki senaryoya Açgözlü Algoritma'yı uygulayarak %100 dal kapsamasını hâlâ sağlayan indirgenmiş bir test takımı oluşturun. Açgözlü Algoritma tarafından döndürülebilecek birden fazla olası test takımı olup olmadığını değerlendirin.
2. Yukarıdaki senaryoya Ek Açgözlü Algoritma'yı uygulayarak %100 dal kapsamasını hâlâ sağlayan indirgenmiş bir test takımı oluşturun. Her adımda, henüz seçilmemiş her test durumunun sağladığı ek kapsamayı belirleyin. Yine, birden fazla olası çözüm olup olmadığını değerlendirin.
3. Harrold ve diğerleri tarafından önerilen, benzersiz şekilde kapsanan hedeflere dayanan algoritmayı uygulayın.

## Test Önceliklendirme

### Görev 2

1. Yukarıdaki senaryoya Açgözlü Algoritma'yı uygulayarak test durumları için bir yürütme sırası oluşturun. Açgözlü Algoritma'nın birden fazla olası sonucu varsa, hepsini listeleyin.
2. Yukarıdaki senaryoya Ek Açgözlü Algoritma'yı uygulayarak test durumları için bir yürütme sırası oluşturun.

### Görev 3

Önceki görevde ürettiğiniz sıralamaları göz önünde bulundurun. Altı test durumunun bir sıralaması verildiğinde, ilk $n$ test durumunun sağladığı kapsamaya bakabiliriz, burada $1 \leq n \leq 6$.

Eğer Açgözlü veya Ek Açgözlü birden fazla sıralama üretebiliyorsa, aşağıda kullanılmak üzere bunlardan birini seçin.

1. Hangi uzunluklarda ($n$ değerleri) Açgözlü ve Ek Açgözlü tarafından üretilen sıralamalar aynı dal kapsamasını üretir?
2. Kapsamada en büyük farka yol açan $n$ değeri nedir ve bu fark ne kadar büyüktür?

## Test Seçimi

Dönemin ilk haftasından [`SpringUtils.duplicateLetters`](../../apps/src/main/java/eru/testing/stringutils/StringUtils.java) metodunu hatırlayın; bu metot için aşağıdaki test takımı verilmiştir.

```java
public class AlternativeStringUtilsTest {

    @Test
    public void shouldReturnEmptySet() {
        Set<Character> resultSet = duplicateLetters("");
        assertFalse(resultSet.contains('s'));
    }

    @Test
    public void shouldNotReturnNonRepeatedChar() {
        Set<Character> resultSet = duplicateLetters("bugs");
        assertFalse(resultSet.contains('s'));
    }

    @Test
    public void shouldReturnRepeatedChar() {
        Set<Character> resultSet = duplicateLetters("software testing");
        assertTrue(resultSet.contains('t'));
    }
}
```

### Görev 4

1. 25. satırdaki ifadenin yanlışlıkla `duplicates.add(si);` ifadesinden `duplicates.clear();` ifadesine değiştirildiği durumda hangi testin yürütüleceğine karar vermek için bir test seçim algoritması uygulayın. Hangi test(ler) seçilmelidir?
