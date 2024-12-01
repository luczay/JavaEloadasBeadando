CREATE TABLE kategoria (
    nev TEXT PRIMARY KEY,  
    ar INTEGER             
);

CREATE TABLE pizza (
    nev TEXT PRIMARY KEY,       
    kategorianev TEXT,           
    vegetarianus BOOLEAN,        
    FOREIGN KEY (kategorianev) REFERENCES kategoria(nev) 
);

CREATE TABLE rendeles (
    az INTEGER PRIMARY KEY AUTOINCREMENT,  
    pizzanev TEXT,                        
    darab INTEGER,                        
    felvetel DATE,                        
    kiszallitas DATE,                   
    FOREIGN KEY (pizzanev) REFERENCES pizza(nev) 
);