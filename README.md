# Drehbuch

## Anforderungen

### Buchverwaltung

- Muss
    - Der Nutzer kann Bücher manuell hinzufügen
    - Der Nutzer kann gespeicherte Bücher bearbeiten und löschen
    - Zu jedem Buch können Titel, Autor und ISBN gespeichert werden
    - Jedem Buch kann mindestens ein Genre zugeordnet werden
    - Alle gespeicherten Bücher werden in einer Bibliothek Ansicht angezeigt
    - Der Nutzer kann Genres bei der Bucherfassung auswählen
    - Der Nutzer kann einzelne Bücher von der Auswahl ausschließen
- Soll
    - Bücher können über ISBN oder Barcode automatisch erfasst werden
- Kann
    - Die App zeigt bei Genre Auswahl an, wie viele Bücher zur Auswahl stehen
    - Für Bücher kann der Klappentext gespeichert und angezeigt werden
    - Der Nutzer kann eine Wunschliste erstellen und teilen

### Zufallsauswahl
- Muss
    - Der Nutzer kann die Zufallsauswahl starten
    - Der Nutzer kann Genres auswählen, aus denen gewählt wird
    - Es wird genau ein Buch ausgegeben
    - Bereits gelesene Bücher werden als "gelesen" markiert und somit von der Auswahl ausgeschlossen
    - Als "gelesen" markierte Bücher können vom Nutzer als "nicht gelesen" markiert werden und somit wieder zur Auswahl hinzu gefügt werden
- Soll
    - Von Reihen wird nur der aktuelle Teil ausgewählt
    - Der Nutzer kann ein anderes Buch auswählen, indem er die Zufallsauswahl wiederholt
    - Die App verhindert eine Auswahl, wenn keine Bücher vorhanden sind
- Kann
    - Das Buch kann als "aktuelles Buch" markiert werden

# Datenbankentwurf

## Daten

### books

| id    | title | isbn          | description   | series_id | series_num|
|-------|-------|---------------|---------------|-----------|-----------|
| UUID  | Text  | VARCHAR(13)   | Text          | UUID      | Number    |

### genres

| id    | name  |
|-------|-------|
| UUID  | Text  |

### authors

| id    | name  |
|-------|-------|
| UUID  | Text  |

### series

| id    | name  |
|-------|-------|
| UUID  | Text  |

### wishlist

| id    | name  |
|-------|-------|
| UUID  | Text  |

## Verknüpfungen

### book_genres

| book_id   | genre_id  |
|-----------|-----------|
| UUID      | UUID      |

### book_authors

| book_id   | author_id |
|-----------|-----------|
| UUID      | UUID      |

### status

| book_id   | is_read   | is_excluded   | is_current|
|-----------|-----------|---------------|-----------|
| UUID      | Boolean   | Boolean       | Boolean   |

### wishlist_books

| book_id   | wishlist_id   |
|-----------|---------------|
| UUID      | UUID          |




This is a Kotlin Multiplatform project targeting Android, iOS.

* [/iosApp](./iosApp/iosApp) contains an iOS application. Even if you’re sharing your UI with Compose Multiplatform,
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

* [/shared](./shared/src) is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - [commonMain](./shared/src/commonMain/kotlin) is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    the [iosMain](./shared/src/iosMain/kotlin) folder would be the right place for such calls.
    Similarly, if you want to edit the Desktop (JVM) specific part, the [jvmMain](./shared/src/jvmMain/kotlin)
    folder is the appropriate location.

### Running the apps

Use the run configurations provided by the run widget in your IDE's toolbar. You can also use these commands and options:

- Android app: `./gradlew :androidApp:assembleDebug`
- iOS app: open the [/iosApp](./iosApp) directory in Xcode and run it from there.

### Running tests

Use the run button in your IDE's editor gutter, or run tests using Gradle tasks:

- Android tests: `./gradlew :shared:testAndroidHostTest`
- iOS tests: `./gradlew :shared:iosSimulatorArm64Test`

---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…