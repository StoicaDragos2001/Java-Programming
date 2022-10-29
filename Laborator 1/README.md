# Stoica Dragos-Stefan 2A5
Exercitiile din laboratul 1

1. Compulsory: O clasa main cu metode care proceseaza cerintele date

3. Homework:

-Validare de argumente - primele 2 trebuie sa fie integer, urmatoarele litere din alfabet. Se accepta un input de minim 3 caractere. (clasa Validate + metoda in main)

-Afisam array-ul de n cuvinte a cate p litere generate de alfabet. (clasa Creator)

-Se verifica vecinatatea intre cuvinte cu o matrice booleana si se retin vecinatatile pt fiecare cuvant intr-o structura de date care e afisata. (clasa Neighbours)

-Pentru n>=150 nu se mai face display la vecinatati, insa putem vedea running time-ul pentru un n>30000. Spre exemplu pentru java -Xms4G -Xmx4G Main.java 30000 2 A B C obtinem 29579914500 nanoseconds. (clasa Neighbours)

-The app launches for a command like: java Main.java 7 2 A B C D E F (rulat pe terminalul de intellij). Output:

Valid arguments!

BF FF BD BA BE AD BA 

Vecini pentru cuvantul BF: FF BD BA BE BA

Vecini pentru cuvantul FF: BF

Vecini pentru cuvantul BD: BF BA BE AD BA

Vecini pentru cuvantul BA: BF BD BE AD BA

Vecini pentru cuvantul BE: BF BD BA BA

Vecini pentru cuvantul AD: BD BA BA

Vecini pentru cuvantul BA: BF BD BA BE AD

Largest subset found: AD BA BF FF

Largest K length: 4

14254000 nanoseconds

3. Bonus:
-Pentru a gasi un subset maximal folosim un algoritm de complexitate O(n) astfel: Cautam perechi consecutive de cuvinte in array-ul generat cu conditia ca matrix[index][index+1]=true; Aceasta conditie indica vecinatatea. Apoi studiem cazul matrix[n-1][0]: in cazul in care gasim true, cautam vecinatati de la inceputul sirului cat timp conditia pe matrice e true, in timp ce tinem cont de lungimea sirului (avem 2 conditii de oprire, un bound si conditia impusa de matrice). La finalul programului vom avea retinuti indexii de incepere respectiv finalizare a subsetului din array, subset pe care il afisam. (clasa Bonus)
              
