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

| id | title | isbn | description | series_id | series_num |
|---|---|---|---|---|---|
| UUID | Text | VARCHAR(13) | Text | UUID | Number |

### genres

| id | name |
|---|---|
| UUID | Text |

### authors

| id | name |
|---|---|
| UUID | Text |

### series

| id | name |
|---|---|
| UUID | Text |

### wishlist

| id | name |
|---|---|
| UUID | Text |

## Verknüpfungen

### book_genres

| book_id | genre_id |
|---|---|
| UUID | UUID |

### book_authors

| book_id | author_id |
|---|---|
| UUID | UUID |

### status

| book_id | is_read | is_excluded | is_current |
|---|---|---|---|
| UUID | Boolean | Boolean | Boolean |

### wishlist_books

| book_id | wishlist_id |
|---|---|
| UUID | UUID |

