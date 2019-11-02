# Cache-Memory

  Java program that simulates cache memory.

-----------------------------------------------------------------
				Give me more subscriptions
-----------------------------------------------------------------


*Clase utilizate

 - Main - clasa principala
 - Operations
 - LRUCache      }
 - FIFOCache     } implementeaza interfata Cache
 - LFUCache      }
 - Subscriptie
     |      
      - Free
           |
            - Basic
                 |
                  - Premium
 

*Implementare

 ! In proiectul realizat, orice obiect adaugat este un element de tip Premium (utilizarea lantului de mostenire), preluand metodele din clasele care ii sunt parinte (Basic, Free, Subscriptie).

 - Operatiile pentru memoria principala, care a fost implementata folosind un vector cu elemente de tip Premium, se afla in clasa Operations. Aceasta clasa are un constructor care primeste un parametru intreg care reprezinta dimensiunea maxima a memoriei (vectorului). De asemenea, aici se afla metode pentru a decrementa cereri in urma unei operatii GET(atat premium, cat si basic), a afla daca un element este sau nu in memorie si a gasi un element dupa nume in memorie.

  Tipurile de cache 
  -----------------

 ! In toate cele 3 cazuri, memoria cache a fost implementata cu ajutorul clasei ArrayList din Java.

 ! Cele 3 clase pentru tipuri ale memoriei cache au aceleasi metode (toate implementeaza interfata Cache). Printre acestea se numara metoda isInCacheMemory ce intoarce true daca elementul cu numele dat ca parametru se afla in memoria cache sau false altfel si metoda getElementCache care returneaza elementul cu numele dat ca peremtru sau null daca nu se gaseste in memorie.

 - LRU (Least Recently Used) - de fiecare data cand un element din cache este accesat acesta se muta la sfarsitul structurii (se elimina si se adauga iar);
					 - atunci cand memoria cache este plina, se elimina primul element, adica elementul care a fost utilizat cel mai de demult.

 - FIFO (First In First Out) - se elimina elementul cu index-ul 0

 - LFU (Least Frequently Used) - la fiecare operatie GET pe un element care este deja in cache numarul de aparitii creste (este initializat cu 1);
					    - pentru eliminare se calculeaza numarul minim de aparitii si pozitia elementului (care detine minimul) in structura 


*Mod de functionare 

 - Atat citirea din fisier, cat si scrierea in fisier se realizeaza in clasa principala a proiectului, Main.

 - Se citeste cacheType de pe prima linie, maxNoObjects (dimensiunea maxima a memoriei cache) de pe a doua si N (numarul de comenzi) de pe a treia.

 - Se defineste cache care este instantiata cu new in functie de cacheType (LRU / FIFO / LFU).

 - Se defineste op de tip Operations + apeleaza constructorul cu parametru intreg N care da dimensiunea maxima a memoriei principale.

 - Se citesc N linii din fisier (N comenzi de tip ADD si GET).

 - La intalnirea comenzii ADD se adauga un element in memoria principala; mai intai se verifica daca acesta se afla deja in memorie, caz in care se suprascriu cererile (basic si premium) si se verifica daca se afla si in memoria cache pentru a fi eliminat.

 - La intalnirea comenzii GET - in cazul in care elementul se afla deja in cache, creste numarul de aparitii pentru implementarea LFU sau se muta elementul curent la final pentru implementarea LRU;
					   - se adauga element in cache, in cazul in care se afla doar in memoria principala pana la acel moment;
					   + se decrementeaza cererea (fie ea basic sau premium).

 ! Afisarea tipului de subscriptie se face prin metoda print din clasa Free, care utilizeaza metodele de verificare daca subscriptia este basic sau daca este premium. Pentru aceasta se utilizeaza lantul mostenirilor.

