# Procesator de Date: Colecții Java Moderne & Stream API

Acest proiect demonstrează utilizarea funcționalităților avansate ale limbajului Java (JDK 17+) pentru gestionarea datelor, punând accent pe ierarhia Collection Framework, Stream API și serializarea JSON polimorfă. Proiectul a fost dezvoltat în cadrul laboratorului de Programare Java.

## Funcționalități 

### 1. Managementul Colecției de Cărți (`Map` & `Record`)
* **Modelarea Datelor**: Utilizează tipul modern **Java Record** pentru a crea o entitate concisă `Carte`.
* **Stocare Eficientă**: Implementează un `HashMap<Integer, Carte>` unde ID-urile unice servesc drept chei pentru acces rapid.
* **Sintaxă Modernă**: Folosește inferența tipului pentru variabilele locale (`var`) pentru un cod mai curat și lizibil.
* **Procesare prin Stream API**: 
    * Filtrarea înregistrărilor după autor folosind metodele `filter()` și `collect()`.
    * Sortarea dinamică a datelor utilizând **Expresii Lambda** și **Referințe la metode**.
    * Gestionarea sigură a datelor prin clasa `Optional` pentru a evita erorile de tip Null.

### 2. Gestiunea Instrumentelor Muzicale (`Polimorfism` & `JSON`)
* **Ierarhie de Clase**: O clasă de bază abstractă `InstrumentMuzical` cu implementări concrete pentru `Chitara` și `SetTobe`.
* **Serializare Polimorfă JSON**: Configurarea avansată a obiectului Jackson `ObjectMapper` folosind adnotația `@JsonTypeInfo` pentru a păstra tipul obiectelor în timpul salvării în fișier.
* **Integritatea Datelor**: Suprascrierea metodelor `equals()` și `hashCode()` pentru a asigura unicitatea elementelor într-o colecție de tip `Set`.
* **Filtrare Avansată**: Utilizarea metodelor `removeIf()`, `instanceof` și `getClass()` în interiorul fluxurilor (Streams) pentru gestionarea categoriilor de instrumente.

## 🛠️ Tehnologii Utilizate
* **Limbaj**: Java 17
* **Tool de Build**: Maven
* **Biblioteci**: Jackson Databind (pentru procesarea fișierelor JSON)
* **Concepte**: Programare Orientată pe Obiect (Polimorfism, Abstracție), Programare Funcțională (Streams, Lambdas).

## 📋 Instrucțiuni de Rulare
1. Asigurați-vă că aveți instalat **Java 17** și **Maven**.
2. Clonați repository-ul:
   ```bash
   git clone [https://github.com/teodora2512/stream-api-data-processor.git](https://github.com/teodora2512/stream-api-data-processor.git)
