# language: de
@ignore
Funktionalität: Als angemeldeter Nutzer kann ich einen Studiengang, Semester, Modul auswählen, damit ich die richtige Klausur finde

  Grundlage: es sind folgende Studiengänge, Semester, Module, Klausurliste in der Datenbank

  Szenariogrundriss:
    Angenommen es gibt die Studiengänge <courses>
    Und es gibt folgende Semester <semester>
    Und es gibt folgende Module in WI1 <modules_WI_1>
    Und es gibt folgende Module in WI4 <modules_WI_4>
    Und es gibt folgende Module in AI3 <modules_AI_3>
    Und es gibt folgende Module in AI5 <modules_AI_5>
    Und es gibt folgende Jahre in WI1 <year>


    Beispiele:
      | courses               | semester |
      | Wirtschaftsinformatik | 1,4      |
      | Angewandte Informatik | 3,5      |

    Beispiele: Module WI1
      | modules_WI_1      | year                          |
      | Grundlagen der WI | SS2018, SS2019, SS2020,SS2021 |
      | BWL1              | WS2019/2020, SS2020           |

    Beispiele: Module WI4
      | modules_WI_4 |
      | SEA2         |
      | WI2          |

    Beispiele: Module AI3
      | modules_AI_3    |
      | Programmieren 3 |

    Beispiele: Module AI5
      | modules_AI_5 |
      | Rechnernetze |

    Beispiele:
      | coursesId             | semesterId | modules           |
      | Wirtschaftsinformatik | 1          | Grundlagen der WI |
      | Wirtschaftsinformatik | 1          | BWL1              |
      | Wirtschaftsinformatik | 4          | SEA2              |
      | Wirtschaftsinformatik | 4          | WI2               |
      | Angewandte Informatik | 3          | Programmieren 3   |
      | Angewandte Informatik | 5          | Rechnernetze      |


  Szenario: Ein Nutzer möchte einen Studiengang auswählen
    Angenommen ein Nutzer ist eingeloggt
    Wenn der Nutzer die Studiengänge anfordert
    Dann bekommt er die Studiengänge <courses> angezeigt

  Szenario: Ein Nutzer möchte ein Semester auswählen
    Angenommen ein Nutzer ist eingeloggt
    Und hat den Studiengang Wirtschaftsinformatik gewählt
    Wenn er sein Semester anzeigen möchte
    Dann bekommt er die Semester <semester> angezeigt

  Szenario: Ein Nutzer möchte ein Modul auswählen
    Angenommen ein Nutzer ist eingeloggt
    Und hat den Studiengang Wirtschaftsinformatik gewählt
    Und das Semester 1 gewählt
    Wenn der Nutzer die Module anfordert
    Dann bekommt er die Module <modules_WI_1> angezeigt

  Szenario: Ein Nutzer möchte eine Klausur auswählen
    Angenommen ein Nutzer ist eingeloggt
    Und hat den Studiengang Wirtschaftsinformatik gewählt
    Und das Semester 1 gewählt
    Und das Modul BWL1 gewählt
    Wenn der Nutzer die Klausuren anfordert
    Dann bekommt er die Klausuren <year> angezeigt

