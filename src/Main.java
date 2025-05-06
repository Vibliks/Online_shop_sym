//Klasy/interfejsy, dziedziczenie, kolekcje, strumienie, ...
//
//        1. Obowiązkowa nazwa projektu: GUI_S1_NI_SNUMER, gdzie N to pierwsza litera nazwiska, I to pierwsza litera imienia, NUMER to numer studenta, np. GUI_S1_KJ_S12345 dla studenta Jana Kowalskiego z numerem S12345. Nie używamy polskich liter (ą, ę, ...).
//
//        2. Należy spakować (.zip, nie rar!) i wysłać całe archiwum a nie jedynie pliki z kodem źródłowym. Przykładowa nazwa pliku do wysłania: GUI_S1_KJ_S12345.zip
//
//3. Plik .zip należy przesłać przed końcem określonego czasu do zadania o nazwie ..._PRO1 w zakładce Zadania/Assignments na platformie MS Teams.
//
//4. Obowiązkowe jest wciśnięcie przycisku Prześlij/Turn in (znajdującego się w prawym górnym rogu) po umieszczeniu rozwiązania w odpowiednim miejscu.
//
//        5. W czasie obrony prowadzący ma prawo zapytać o teoretyczne podstawy stojące za wykorzystanymi przez studenta mechanizmami. Ponadto student może zostać poproszony o modyfikację kodu. Brak prawidłowej odpowiedzi lub niezmodyfikowanie kodu oznacza 0 pkt.
//
//6. Nie należy nadużywać komentarzy w kodzie (np. przy każdej instrukcji...). Czytanie komentarzy w czasie obrony jest niedozwolone.
//
//7. Kopiowanie kodu/powielanie kodu/przekazywanie swojego kodu innej osobie lub niesamodzielne wykonanie projektu w dowolnej formie skutkuje uzyskaniem 0 pkt.
//
//
//
//        Zadanie projektowe (15p)
//
//Napisać aplikację symulującą uproszczony proces zamawiania (i płacenia) programów w serwisie oferującym materiały multimedialne na żądanie.
//
//Serwis oferuje różne typy programów, każdy program ma swój tytuł oraz gatunek (obyczaj, dramat, sensacja, ...).
//Programy różnych gatunków mogą mieć wspólny tytuł. Programy mogą być oglądane na różnych urządzeniach. Ceny programów znajdują się w cenniku. Cennik można,
// w dowolnym momencie i wielokrotnie modyfikować  poprzez dodawanie nowych cen, przy czym nowa cena istniejącego programu powinna zastępować poprzednią cenę.
//
//Klienci po rejestracji otrzymują identyfikatory oraz deklarują kwotę pieniędzy, którą chcą wydać na zamówienia.
//Klienci mogą (ale nie muszą) posiadać abonament. Klienci wybierają programy i umieszczają je na swojej tzw. liście życzeń. Następnie, być może po jakimś czasie,
//w celu finalizacji zamówienia przepakowują programy do koszyka (po uprzednim wyczyszczeniu) i zapłacą za jego zawartość. Każdy klient może mieć tylko 1 listę życzeń i 1 koszyk.
//Klienci mogą płacić kartą lub przelewem bankowym. Po zapłaceniu, klient ma możliwość dokonania zwrotu do koszyka (tylko z ostatniej transakcji) części
//lub całej ilości niewykorzystanych programów/urządzeń.
//
//Aplikacja powinna być napisana tak, aby następujący, przykładowy program

// import...
import Films.*;
import static Film_type.Film_type.*;
import static BOOL.BOOL.*;
import static Payment.Payment_Type.*;
import Film_type.Film_type;
import shop.*;
import Basket.*;
import Client.*;
import Payment.Payment_Type;
public class Main {

    // cena programów danego gatunku z koszyka
    static int price(Basket basket, Film_type genre) {
        return (int) basket.getPrograms().stream()
                .filter(program -> program.getType() == genre)
                .mapToDouble(program -> program.Getcena(true))
                .sum();
    }


    public static void main(String[] args) {

        // cennik
        Pricelist cennik = Pricelist.getPricelist();

        // dodawanie nowych cen do cennika
        cennik.add(MUSICAL, "Król lew", 5, 3, 12, 6);    // metoda przyjmująca 6 parametrów
        // (kolejność, typy i oznaczenie parametrów są obowiązkowe, podane argumenty wywołania są przykładowe):
        // "próg" urządzeń: 3
        // jeśli klient ma abonament: 5 zł/urządzenie (z dowolną liczbą urządzeń)
        // jeśli klient nie ma abonamentu: do 3 urządzeń za 12 zł/urządzenie,
        // w przeciwnym przypadku (wpp.) 6 zł/urządzenie

        cennik.add(Film_type.DRAMA, "Król Lear", 2, 15, 10);    // metoda przyjmująca 5 parametrów
        // (kolejność, typy i oznaczenie parametrów są obowiązkowe, podane argumenty wywołania są przykładowe):
        // "próg" urządzeń: 2
        // niezależnie od tego, czy klient posiada abonament czy nie
        // do 2 urządzeń za 15 zł/urządzenie, wpp. 10 zł/urządzenie

        cennik.add(COMEDY, "Królowa", 7, 14);        // metoda przyjmująca 4 parametry
        // (kolejność, typy i oznaczenie parametrów są obowiązkowe, podane argumenty wywołania są przykładowe):
        // 7 zł/urządzenie jeśli klient ma abonament, wpp. 14 zł/urządzenie


        cennik.add(COMEDY, "Król", 5, 10);


        cennik.add(ACTION, "Król Artur");        // metoda przyjmująca 2 parametry
        // (kolejność, typy i oznaczenie parametrów są obowiązkowe, podane argumenty wywołania są przykładowe):
        // darmowy dostęp
        //System.out.println(cennik);
        //System.out.println("=============== \n");
        System.out.println("\n");
        cennik.remove(Film_type.COMEDY, "Król");            // metoda remove (do usunięcia ceny konkretnego programu) przyjmująca 2 parametry

        System.out.println(cennik);

        // Klient Kinoman deklaruje kwotę 60 zł na zamównienia, posiada abonament w serwisie
        Client kinoman = new Client("Kinoman", 60, YES);

        // Klient Kinoman dodaje do listy życzeń różne programy:
        // "Król Lear" typu obyczajowego na 4 urządzeniach,
        // "Król Artur" typu sensacyjnego na 3 urządzeniach,
        // "Król lew" typu muzycznego na 2 urządzeniach,
        // "Korona" typu komediowego na 2 urządzeniach,
        kinoman.add(new Drama("Król Lear", 4));
        kinoman.add(new Action("Król Artur", 3));
        kinoman.add(new Musical("Król lew", 2));
        kinoman.add(new Comedy("Korona", 2));


//        // Lista życzeń klienta Kinoman
        Wishlist listaKinomana = kinoman.getWishList();

        System.out.println("Lista życzeń klienta " + listaKinomana);

        //wyprowadził na konsolę podobne do poniższych wyniki:
//Lista życzeń klienta Kinoman:
//        Król Lear, typ: obyczaj, ile: 4 urządzenia, cena 10.00
//        Król Artur, typ: sensacja, ile: 3 urządzenia, cena 0.00
//        Król lew, typ: muzyczny, ile: 2 urządzenia, cena 5.00
//Korona, typ: komedia, ile: 2 urządzenia, ceny brak

        // Przed płaceniem, klient przepakuje programy z listy życzeń do koszyka.
        // Możliwe, że na liście życzeń są programy niemające ceny w cenniku,
        // w takim przypadku nie trafiłyby do koszyka
        Basket koszykKinomana = kinoman.getBasket();
        kinoman.pack();

        // Co jest na liście życzeń klienta Kinomana
        System.out.println("Po przepakowaniu, lista życzeń klienta  " + kinoman.getWishlist());

        //        Po przepakowaniu, lista życzeń klienta Kinoman:
//Korona, typ: komedia, ile: 2 urządzenia, ceny brak

        // Co jest w koszyku klienta Kinoman
        System.out.println("Po przepakowaniu, koszyk klienta " + koszykKinomana);

//        Po przepakowaniu, koszyk klienta Kinoman:
//        Król Lear, typ: obyczaj, ile: 4 urządzenia, cena 10.00
//        Król Artur, typ: sensacja, ile: 3 urządzenia, cena 0.00
//        Król lew, typ: muzyczny, ile: 2 urządzenia, cena 5.00


        // Ile wynosi cena wszystkich programów typu obyczajowego w koszyku klienta Kinoman
        System.out.println("\n Progamy obyczajowe w koszyku klienta Kinoman kosztowały:  " + price(koszykKinomana, Film_type.DRAMA));




        // Klient zapłaci...
        kinoman.pay(CARD, false);	// płaci kartą płatniczą, prowizja 2%
        // true oznacza, że w przypadku braku środków aplikacja sam odłoży nadmiarowe programy,
        // wpp. rezygnacja z płacenia razem z czyszczeniem koszyka i listy życzeń

        // Ile klientowi Kinoman zostało pieniędzy?
        System.out.println("\n Po zapłaceniu, klientowi Kinoman zostało: " + kinoman.getWallet() + " zł");

        // Mogło klientowi zabraknąć srodków, wtedy opcjonalnie programy mogą być odkładane,
        // wpp. koszyk jest pusty po zapłaceniu
        System.out.println("\n Po zapłaceniu, koszyk klienta " + kinoman.getBasket());
        System.out.println("\n Po zapłaceniu, koszyk klienta " + koszykKinomana);

        // Teraz przychodzi klient Krytyk,
        // deklaruje 60 zł na zamówienia
        Client krytyk = new Client("Krytyk", 60, NO);

        // Zamówił za dużo jak na tę kwotę
        krytyk.add(new Musical("Król lew", 2));
        krytyk.add(new Comedy("Królowa", 3));

        // Co klient Krytyk ma na swojej liście życzeń
        System.out.println("Lista życzeń klienta " + krytyk.getWishlist());

        Basket koszykKrytyka = krytyk.getBasket();
        krytyk.pay();

        // Co jest na liście życzeń klienta Krytyk
        System.out.println("Po przepakowaniu, lista życzeń klienta " + krytyk.getWishlist());

        // A co jest w koszyku klienta Krytyk
        System.out.println("Po przepakowaniu, koszyk klienta " + krytyk.getBasket());

        // klient Krytyk płaci
        krytyk.pay(TRANSFER, true);	// płaci przelewem, bez prowizji

        // Ile klientowi Krytyk zostało pieniędzy?
        System.out.println("Po zapłaceniu, klientowi Krytyk zostało: " + krytyk.getWallet() + " zł");

        // Co zostało w koszyku klienta Krytyk (za mało pieniędzy miał)
        System.out.println("Po zapłaceniu, koszyk klienta " + koszykKrytyka);

        krytyk.returnVOD(COMEDY, "Królowa", 1);	// zwrot (do koszyka) 1 urządzenia programu komediowego "Królowa" z ostatniej transakcji

        // Ile klientowi krytyk zostało pieniędzy?
        System.out.println("Po zwrocie, klientowi krytyk zostało: " + krytyk.getWallet() + " zł");

        // Co zostało w koszyku klienta krytyk
        System.out.println("Po zwrocie, koszyk klienta " + koszykKrytyka);

    }
}

//wyprowadził na konsolę podobne do poniższych wyniki:
//Lista życzeń klienta Kinoman:
//        Król Lear, typ: obyczaj, ile: 4 urządzenia, cena 10.00
//        Król Artur, typ: sensacja, ile: 3 urządzenia, cena 0.00
//        Król lew, typ: muzyczny, ile: 2 urządzenia, cena 5.00
//Korona, typ: komedia, ile: 2 urządzenia, ceny brak
//
//        Po przepakowaniu, lista życzeń klienta Kinoman:
//Korona, typ: komedia, ile: 2 urządzenia, ceny brak
//
//        Po przepakowaniu, koszyk klienta Kinoman:
//        Król Lear, typ: obyczaj, ile: 4 urządzenia, cena 10.00
//        Król Artur, typ: sensacja, ile: 3 urządzenia, cena 0.00
//        Król lew, typ: muzyczny, ile: 2 urządzenia, cena 5.00
//
//Progamy obyczajowe w koszyku klienta Kinoman kosztowały: 40.00
//
//        Po zapłaceniu, klientowi kinoman zostało: 9.00 zł
//
//        Po zapłaceniu, koszyk klienta Kinoman: -- pusto
//        Po zapłaceniu, koszyk klienta Kinoman: -- pusto
//
//Lista życzeń klienta Krytyk:
//        Król lew, typ: muzyczny, ile: 2 urządzenia, cena 12.00
//Królowa, typ: komedia, ile: 3 urządzenia, cena 14.00
//
//        Po przepakowaniu, lista życzeń klienta Krytyk: -- pusto
//
//        Po przepakowaniu, koszyk klienta Krytyk:
//        Król lew, typ: muzyczny, ile: 2 urządzenia, cena 12.00
//Królowa, typ: komedia, ile: 3 urządzenia, cena 14.00
//
//        Po zapłaceniu, klientowi krytyk zostało: 6.00 zł
//
//        Po zapłaceniu, koszyk klienta krytyk:
//        Król lew, typ: muzyczny, ile: 1 urządzenie, cena 12.00
//
//        Po zwrocie, klientowi krytyk zostało: 20.00 zł
//
//        Po zwrocie, koszyk klienta krytyk:
//        Król lew, typ: muzyczny, ile: 1 urządzenie, cena 12.00
//Królowa, typ: komedia, ile: 1 urządzenie, cena 14.00
//Dodawanie nowych typów programów (podobnych do Drama, Comedy, Musical, ...) musi być zrealizowane w sposób bardzo prosty, polegający na dodawaniu tylko nowej klasy (i ewentualnie powiązanego z klasą interfejsu/enum/...), w takim przypadku modyfikacja pozostałych klas jest niedozwolona.

//Wymagania dodatkowe:
//korzystanie z klas abstrakcyjnych/interfejsów oraz z polimorfizmu jest obowiązkowe
//pożądana jest minimalizacja kodu klas Client.Client.Wishlist oraz Basket.Basket
//istnieje tylko jeden obiekt-cennik oraz jeden obiekt-koszyk (na klienta), do których dostęp powinien być realizowany wyłącznie za pomocą metody getPricelist()/getBasket()
//Ważne uwagi:
//Być może są programy niemające ceny w cenniku, wtedy przy przepakowaniu z listy życzeń do koszyka nie są one usuwane z listy życzeń i nie trafią do koszyka.
//Niektóre programy posiadają różne ceny w zależności od liczby urządzeń, na których klienci mogą je wyświetlić.
//Jeśli klient nie ma wystarczającej ilości pieniędzy na całą zawartość koszyka to, zależy od opcji, może zapłacić za część koszyka o ile zapłacona kwota (za dany program) jest wielokrotnością ceny tego programu na 1 urządzeniu (oczywiście zgodnie z cennikiem), w takim przypadku o wyborze programów do zapłacenia zdecyduje aplikacja.
//Przy płaceniu kartą płatniczą klient zapłaci dodatkowo 2% prowizji.
//Przy zwrocie programów z ostatniej transakcji, aplikacja powinna zwrócić klientowi właściwą ilość środków (o ile jest >=0) uwzględniając faktycznie niezwrócone programy (zgodnie z cennikiem). Nie ma zwrotu prowizji.
//Zdefiniowanie odpowiedniej metody toString() w niektórych klasach jest obowiązkowe.
//Aplikacja powinna działać dla dowolnych danych a nie tylko dla tych podanych w powyższym programie. Wszystkie opisane operacje mogą być wykonywane wielokrotnie. Przykładowy program nie uwzględnia wszystkich możliwych sytuacji podanych w opisie zadania.