const fs = require("fs");

const citiesString = "Kirkland,Bellingham,Indio,Livermore,San Leandro,Tracy,Westminster,Redding,Santa Barbara,Santa Monica,Carson,Chico,Yakima,Bend,Hesperia,South Gate,Mission Viejo,San Marcos,Federal Way,Beaverton,Compton,Spokane Valley,Vacaville,Renton,Vista,Rialto,El Cajon,San Mateo,Burbank,Jurupa Valley,Norwalk,Hillsboro,Santa Maria,Daly City,West Covina,Clovis,Richmond,Everett,Inglewood,Ventura,Gresham,Antioch,Downey,Murrieta,Costa Mesa,Temecula,Carlsbad,El Monte,Fairfield,Vallejo,Berkeley,Victorville,Simi Valley,Santa Clara,Kent,Thousand Oaks,Concord,Visalia,Roseville,Fullerton,Orange,Pasadena,Bellevue,Torrance,Escondido,Pomona,Sunnyvale,Palmdale,Salinas,Lancaster,Hayward,Corona,Eugene,Salem,Elk Grove,Garden Grove,Santa Rosa,Oceanside,Vancouver,Rancho Cucamonga,Huntington Beach,Glendale,Moreno Valley,Oxnard,Santa Clarita,Fontana,Tacoma,Ontario,San Bernardino,Spokane,Fremont,Chula Vista,Irvine,Anchorage,Stockton,Riverside,Santa Ana,Anaheim,Bakersfield,Oakland,Long Beach,Sacramento,Fresno,Modesto,Portland,Seattle,San Francisco,San Jose,San Diego,Los Angeles"
const cities = citiesString
    .split(",")
    .sort()
    // .splice(0, 20);

const CITY_FILE_NAME = "cityFile";
const FLIGHT_FILE_NAME = `flightFile`;
const MAX_FLIGHTS = 3;

fs.writeFileSync(CITY_FILE_NAME, cities.join("\n"));

function genFlightsOneCity(origin) {
    const numOfFlights = Math.floor(Math.random() * (cities.length - 1) + 1);
    const destinations = [];
    for (let i = 0; i < numOfFlights; i++) {
        let destination = null;
        while (!destination || origin === destination || destinations.includes(destination)) {
            destination = cities[Math.floor(Math.random() * cities.length)];
        }
        destinations.push(destination);
    }
    return destinations.map(destination => ({
        origin,
        cost: Math
            .floor(Math
                .random() * (1e3 - 10) + 10),
        destination
    }));
}

fs.writeFileSync(
    FLIGHT_FILE_NAME,
    cities
        .reduce((acc, city) => ([
            ...acc,
            ...genFlightsOneCity(city)
        ]), [])
        .map(({origin, destination, cost}) => `${origin},${destination},${cost}`)
        .join("\n")
);
