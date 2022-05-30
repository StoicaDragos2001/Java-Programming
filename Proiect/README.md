# rideShare

![image](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![image](https://img.shields.io/badge/PLSQL-F80000?style=for-the-badge&logo=oracle&logoColor=black)

## Authors
- [Petrea Daniela](https://github.com/Daniela-Petrea)
- [Stoica Dragos](https://github.com/StoicaDragos2001)

## About rideShare

  Aplicație din categoria [SMART CITY](https://iasismartcity.ro/) de impartire a călătoriei pentru persoane care merg în aceeași zonă și au locuri libere în mașină. Scopul este acela de a se reduce necesarul de locuri de parcare si aglomeratia urbana. 

## Tech details

  - Proiectul este modelat dupa ```arhitectura MVC```.
  - Interfata grafica este realizata in ```JavaFX```.
  - Comunicam cu o baza de date tip ```Oracle SQL```. Avem 3 tabele: 
 
            1. ridesTable pentru curse disponibile 
            2. usersTable pentru gestionarea conturilor 
            3. Romanian_cities unde facem ```SEED``` unui csv.
  - Utilizam un ```Daemon Thread``` cu scop de ```garbage collector``` pentru datele din ridesTable care nu mai sunt relevante.
  - Proiectul este documentat cu ```JavaDoc```

## Flow description
  
  Interfata prezinta initial un landing page care da posibilitatea de "Login", conturile fiind stocate in usersTable. De asemenea se ofera posibilitatea de "Offer a ride" si "Search a ride". 
  
  Pe Login utilizatorul este invitat sa se conecteze (este redirectat la login si din offer a ride si search a ride deoarece inca nu este conectat), verificandu-se credentialele in baza de date sau sa se inregistreze cu un cont nou, care sa respecte anumite conditii la create. Mai apoi acesta este redirectionat la landing, de unde are acces la celelalte 2 butoane. 
  
  Offer a ride permite user-ului sa introduca o cursa la o anumita data, specificand locatia de plecare, cea de sosire, numarul de locuri disponibile in masina si pretul acestei curse, detaliile fiind stocate in ridesTable. 
  
  In cazul butonului de search a ride, user-ul completeaza un formular asemanator, care este folosit pentru a realiza un matchmaking in baza de date, fiind apoi redirectionat pe o pagina cu posibile variante pentru o astfel de cursa. 
  
  Cursele mai vechi decat data curenta sunt eliminate zilnic din baza de date de catre un low priority thread. 

