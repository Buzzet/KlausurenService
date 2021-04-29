# language: de
Funktionalität: Als angemeldeter Nutzer kann ich einen Studiengang, Semester, Modul auswählen, damit ich die richtige Klausur finde
  Szenario: Ein Nutzer möchte einen Studiengang auswählen
    Angenommen ein Nutzer ist eingeloggt
    Und es gibt folgende Daten in der Datenbank
      | KlausurWIGWISS2018  | Wirtschaftsinformatik | Schultz     | 1 | Grundlagen der WI | SS2018 |
      | KlausurWIGWISS2019  | Wirtschaftsinformatik | Schultz     | 1 | Grundlagen der WI | SS2019 |
      | KlausurWIGWIWS2019  | Wirtschaftsinformatik | Schultz     | 1 | Grundlagen der WI | WS2019 |
      | KlausurWIGWIWS2020  | Wirtschaftsinformatik | Schön       | 1 | Grundlagen der WI | WS2020 |
      | KlausurWIBWLWS2019  | Wirtschaftsinformatik | Sarstedt    | 1 | BWL1              | WS2019 |
      | KlausurWIBWLWS2020  | Wirtschaftsinformatik | Sarstedt    | 1 | BWL1              | WS2020 |
      | KlausurWISEA2SS2018 | Wirtschaftsinformatik | Steffens    | 4 | SEA2              | SS2018 |
      | KlausurWISEA2SS2019 | Wirtschaftsinformatik | Steffens    | 4 | SEA2              | SS2019 |
      | KlausurWIWI2SS2008  | Wirtschaftsinformatik | Schultz     | 4 | WI2               | SS2008 |
      | KlausurAIPM3SS2028  | Angewandte Informatik | Schmolitzky | 3 | Programmieren 3   | SS2028 |
      | KlausurAIRNSS2018   | Angewandte Informatik | Hübner      | 5 | Rechnernetze      | SS2018 |
    Wenn er sein Semester anzeigen möchte
    Dann bekommt er die Semester <semester> angezeigt

  Szenario: Ein Nutzer möchte ein Modul auswählen
    Angenommen ein Nutzer ist eingeloggt
    Und es gibt folgende Daten in der Datenbank
      | KlausurWIGWISS2018  | Wirtschaftsinformatik | Schultz     | 1 | Grundlagen der WI | SS2018 |
      | KlausurWIGWISS2019  | Wirtschaftsinformatik | Schultz     | 1 | Grundlagen der WI | SS2019 |
      | KlausurWIGWIWS2019  | Wirtschaftsinformatik | Schultz     | 1 | Grundlagen der WI | WS2019 |
      | KlausurWIGWIWS2020  | Wirtschaftsinformatik | Schön       | 1 | Grundlagen der WI | WS2020 |
      | KlausurWIBWLWS2019  | Wirtschaftsinformatik | Sarstedt    | 1 | BWL1              | WS2019 |
      | KlausurWIBWLWS2020  | Wirtschaftsinformatik | Sarstedt    | 1 | BWL1              | WS2020 |
      | KlausurWISEA2SS2018 | Wirtschaftsinformatik | Steffens    | 4 | SEA2              | SS2018 |
      | KlausurWISEA2SS2019 | Wirtschaftsinformatik | Steffens    | 4 | SEA2              | SS2019 |
      | KlausurWIWI2SS2008  | Wirtschaftsinformatik | Schultz     | 4 | WI2               | SS2008 |
      | KlausurAIPM3SS2028  | Angewandte Informatik | Schmolitzky | 3 | Programmieren 3   | SS2028 |
      | KlausurAIRNSS2018   | Angewandte Informatik | Hübner      | 5 | Rechnernetze      | SS2018 |
    Und hat den Studiengang Wirtschaftsinformatik gewählt
    Und das Semester 1 gewählt
    Wenn der Nutzer die Module anfordert
    Dann bekommt er die Module <modules_WI_1> angezeigt

  Szenario: Ein Nutzer möchte eine Klausur auswählen
    Angenommen ein Nutzer ist eingeloggt
    Und es gibt folgende Daten in der Datenbank
      | KlausurWIGWISS2018  | Wirtschaftsinformatik | Schultz     | 1 | Grundlagen der WI | SS2018 |
      | KlausurWIGWISS2019  | Wirtschaftsinformatik | Schultz     | 1 | Grundlagen der WI | SS2019 |
      | KlausurWIGWIWS2019  | Wirtschaftsinformatik | Schultz     | 1 | Grundlagen der WI | WS2019 |
      | KlausurWIGWIWS2020  | Wirtschaftsinformatik | Schön       | 1 | Grundlagen der WI | WS2020 |
      | KlausurWIBWLWS2019  | Wirtschaftsinformatik | Sarstedt    | 1 | BWL1              | WS2019 |
      | KlausurWIBWLWS2020  | Wirtschaftsinformatik | Sarstedt    | 1 | BWL1              | WS2020 |
      | KlausurWISEA2SS2018 | Wirtschaftsinformatik | Steffens    | 4 | SEA2              | SS2018 |
      | KlausurWISEA2SS2019 | Wirtschaftsinformatik | Steffens    | 4 | SEA2              | SS2019 |
      | KlausurWIWI2SS2008  | Wirtschaftsinformatik | Schultz     | 4 | WI2               | SS2008 |
      | KlausurAIPM3SS2028  | Angewandte Informatik | Schmolitzky | 3 | Programmieren 3   | SS2028 |
      | KlausurAIRNSS2018   | Angewandte Informatik | Hübner      | 5 | Rechnernetze      | SS2018 |
    Und hat den Studiengang Wirtschaftsinformatik gewählt
    Und das Semester 1 gewählt
    Und das Modul BWL1 gewählt
    Wenn der Nutzer die Klausuren anfordert
    Dann bekommt er die Klausuren <year> angezeigt

