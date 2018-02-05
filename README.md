# Ortodroma

## Funkce
Program pro výpočet vzdálenosti dvou bodů na povrchu koule (délka ortodromy). Po spuštění uživatel zadá zeměpisnou šířku a délku obou bodů ve stupních (ve formě desetiného čísla, nikoliv na minuty a sekundy) a poloměr koule i s jednotkami. Pokud uživatel neazadá žádné nesmyslné údaje, program vypočítá vzdálenost a vypýše ji v zadaných jednotkách.

## Funkčnost
Program funguje pro všechny vstupy, které na kouli při počítání délky ortodromy dávají smysl. Pokud souřadnice budou mimo rozsah -180° až 180° pro zem. délku a -90° až 90° pro zem. šířku, bude program ukončen s chybou a uživatel tedy bude vědět, že zadal nesmyslné souřadnice. To samé platí pro případy zadání poloměru 0 nebo méně. Vše s použitím jednoduchých podmínek if(). Jednotky si uživatel může zadat jaké chce, na výpočet nemají vliv a ani neznám veškéré délkové jednotky na světě.

## Implementace
V hlavní funkci je vytvořeno dvourozměrné pole pro souřadnice bodů. Poté se zavolá funkce, ve které je uživatel postupně vyzýván k napsání zem. šířky 1. bodu φ1 (uloženo do pole na místo [0][0]), zem. délky 1. bodu λ1 (na místo [0][1]), zem. šířky 2. bodu φ2 (na místo [1][0]) a zem. délky 2. bodu λ2 (na místo [1][1]). Dále je vytvořena proměnná r, do které uživatel zadá poloměr koule. Vše pomocí samostatné funkce s použitím BufferedReader. S použitím vloženého BufferedReader uživatel ještě zadá jednotky, které jsou uloženy jako string a poté použity pouze pro výpis za výsledkem. Ten se spočítá v samostatné funkci po zadání všech parametrů a to pomocí vzorce pro délku d ortodromy: 
###### d = r * arccos(sin(φ1) * sin(φ2) + cos(φ1) * cos(φ2) * cos(λ2 - λ1))
