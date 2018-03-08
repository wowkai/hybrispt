package allTests;

import org.apache.commons.lang.time.StopWatch;
import org.testng.annotations.Test;
import parentTest.ParentTest;

public class ManufacturerPartsCount extends ParentTest {

    String[] manufactuters =
            {
//                    "A la Cart",
//                    "AAON",
//                    "AccuTemp",
//                    "Adamatic",
//                    "Adcraft",
//                    "Advance Tabco",
//                    "Aladdin",
//                    "Alto Shaam",
//                    "Amana Menumaster",
//                    "American Dish Service",
//                    "American Dryer Laundry",
//                    "American Foodservice",
//                    "American Panel",
//                    "American Range",
//                    "Amerikooler",
//                    "Anderson Lock",
//                    "Anets",
//                    "Anthony International",
//                    "Antunes",
//                    "Anvil America",
//                    "AO Smith Water Heater",
//                    "APW Wyott",
//                    "Arctic Air",
//                    "Astro Blender",
//                    "Atlas Metal",
//                    "Atosa",
//                    "Autofry",
//                    "Avtec",
//                    "Axis",
//                    "Ayr King",
                    "Baer Supply Company",
                    "Bakers Pride",
                    "Bally Refrigerated Boxes",
                    "Bar Maid",
                    "Baxter",
                    "Beech Ovens",
                    "Belleco",
                    "Belshaw",
                    "Berkel",
                    "Berner International",
                    "Bettcher",
                    "Beverage Air",
                    "Bevles",
                    "Biro",
                    "Bizerba",
                    "BKI",
                    "Blakeslee",
                    "Blendtec",
                    "Blickman",
                    "Blodgett",
                    "Bloomfield",
                    "Bradley Corporation",
                    "Bravo",
                    "Brema",
                    "Bunn",
                    "Butcher Boy Machines",
                    "Cadco",
                    "Caddy",
                    "Cambro",
                    "Capkold",
                    "Captive-Aire",
                    "Caravell",
                    "Carlisle",
                    "Carpigiani",
                    "Carroll Chair",
                    "Carter Hoffmann",
                    "CCI Cool Curtain",
                    "Cecilware",
                    //"Central Specialties Ltd",
                    "Champion",
                    "Champion - Moyer Diebel",
                    "Chicago Faucet",
                    "Chigo-Eurodib",
                    "Cissell",
                    "Clearbev",
                    "Cleveland",
                    "CMA Dish Machines",
                    "Cofrimell",
                    "Comark",
                    "Component Hardware",
                    "Comstock Castle",
                    "Continental Refrigeration",
                    "Convotherm",
                    "Cooper Atkins",
                    "Cornelius",
                    "Cospolich",
                    "Cres Cor",
                    "Cretors",
                    "Criotec",
                    //"Crown Tonka",
                    "Crown Verity",
                    //"CTL Foods Inc",
                    "CTX",
                    "Cutler Cobblestone",
                    "Darling International",
                    //"Day Mark",
                    "Delfield",
                    //"Delta Faucets",
                    "Desco",
                    "Design Tec",
                    "Desmon USA",
                    "Dexter",
                    "Diablo",
                    "Dinex",
                    "Dispense-Rite",
                    //"Display Technologies",
                    "Diversitech",
                    "Donper USA",
                    "Dormont",
                    "Doughpro Proluxe",
                    "Douglas Machines",
                    "Doyon",
                    "Drain Lock",
                    "Duke",
                    "Duratool",
                    //"Dutchess Bakers Mach Co",
                    "Dynamic Mixer",
                    "Eagle-Metal Masters",
                    //"Edgecraft",
                    "Edhard",
                    "Edlund",
                    //"Eger Products",
                    "Electrolux",
                    "Elkay",
                    "Eloma",
                    "Emberglo",
                    "Eurodib",
                    "Everpure",
                    "Evo",
                    "Fagor Commercial",
                    "Falcon Fabricators",
                    "FAST",
                    "Fbd",
                    "Federal Industries",
                    "Fetco",
                    "Fieldpiece",
                    "Filter Corp",
                    //"Filter Express Optipure",
                    "Fisher",
                    "Flameguard",
                    //"Fleetwood",
                    "Flojet",
                    //"Fluidmaster",
                    "Focus Foodservice",
                    "Follett",
                    "Food Warming Equipment",
                    "Franke",
                    "Franke Foodservice Coffee",
                    "Franke Foodservice System",
                    //"Franklin Chef",
                    "Franmara",
                    "Frymaster",
                    "Garland",
                    "Gaylord",
                    "GE Appliance",
                    "Gemini",
                    "General",
                    "Giles",
                    "Glastender",
                    "Globe",
                    "Gold Bond",
                    "Greenheck",
                    "Grindmaster",
                    "Grindmaster Cecilware",
                    "Groen",
                    "H&K International",
                    "Hamilton Beach",
                    "Hardt",
                    "Hatco",
                    "Henny Penny",
                    "Hickory",
                    //"Hobart",
                    "Horton",
                    "Hoshizaki",
                    "Hubbell Heaters",
                    "Huebsch",
                    "Hussmann",
                    "Hydro Systems",
                    "Ice O Matic",
                    "Imperial",
                    "Imperial Brown",
                    "Imperial Eastman",
                    "Industrial Kitchen Parts",
                    "Insinger",
                    "Insinkerator",
                    "Intermetro",
                    "International Cold Storage",
                    "IPSO",
                    "Irinox",
                    "Jacknob",
                    "Jackson",
                    "Jackson Door",
                    "Jade",
                    "Jet Tech",
                    "Jetspray",
                    "Johnson - Rose",
                    "Josam",
                    "Juno Lighting Group",
                    "Kairak",
                    "Kanpak",
                    "Karma",
                    "Kason",
                    "Keating",
                    "Kelvinator",
                    "Kiefer",
                    "Koala",
                    "Kold-Draft",
                    "Kolpak",
                    "Kool Star",
                    "Kool-It",
                    "Krampouz-Eurodib",
                    "Krowne",
                    "Lakeside",
                    "Lamber-Eurodib",
                    "Lancer",
                    "Lang",
                    "LaRosa",
                    "LBC Bakery Equipment",
                    "Le-Jo",
                    "Leer",
                    "Legion",
                    "Lennox",
                    "Lincoln",
                    "Linkrich",
                    "Lockwood",
                    "Lolo",
                    "Magikitchn",
                    "Mahoney",
                    "Malish",
                    "Manitowoc Ice",
                    "Market Forge",
                    //"Mars Air Doors",
                    "Marsal and Sons",
                    "Marshall Air",
                    "Master-Bilt",
                    //"Masterlock",
                    "Maxx Cold",
                    "Maxx Ice",
                    "McCall",
                    //"Mccann",
                    //"Mcgill",
                    "Meiko",
                    //"Meister Cook LLC",
                    "Merco",
                    "Merrychef",
                    "Metro",
                    "Micro Matic",
                    "Middleby",
                    "Milnor",
                    //"Minco",
                    "Minipack America",
                    "Miroil",
                    //"Mod-U-Serve",
                    "Montague",
                    "Moyer Diebel",
                    //"Mr Bar B Q",
                    //"Mulberry",
                    "Multiplex",
                    "Mundial",
                    //"National Controls Corpora",
                    //"National Conveyor Corp",
                    //"National Sign Systems",
                    //"Ncc",
                    "Nemco",
                    "Newco",
                    "Nieco",
                    "NKL Cash Handling",
                    "Norlake",
                    "Norpole",
                    "Norton",
                    "Nu-Calgon",
                    "Nu-Vu",
                    "Nuova Simonelli USA",
                    "Ojeda",
                    "Olfa",
                    "Oliver",
                    "Omega",
                    "Orved-Eurodib",
                    //"Oscartielle / Clabo N A",
                    "Ovention",
                    //"Packless",
                    "Panasonic",
                    //"Paragon",
                    "Pelouze Scale",
                    "Pemko",
                    "Perfect Fry",
                    "Perfection",
                    "Perlick",
                    "Perlick Residential",
                    "Perma-Vault",
                    "Permafil",
                    "Picard Ovens",
                    "Piper Products",
                    "Pitco",
                    "Plews",
                    "Plymold",
                    "Polar King",
                    "Polaris Water Heater",
                    "Power Soak Systems Inc",
                    //"Primo",
                    //"Primo",
                    "Primus Laundry",
                    "Prince Castle",
                    "Proflo",
                    "Q Infrared Ovens",
                    "QBD Modular Systems",
                    "Quality Espresso",
                    "Quality Industries",
                    "Quikserv",
                    "R F Hunter",
                    "Raburn",
                    "Ram",
                    "Rancilio",
                    "Randell",
                    "Rankin Delux",
                    "Rational",
                    "Ready Access",
                    "Red Goat",
                    "Refrigeration Technologie",
                    "Remcor",
                    "Revent",
                    "Rheem",
                    "Robot Coupe",
                    "Rondo",
                    "Rotisol",
                    "Royal Range",
                    "Royalton",
                    "Rubbermaid",
                    "S&G Manufacturing",
                    "Salvajor",
                    "Sammic",
                    "San Jamar",
                    "Saniserv",
                    "Saturn",
                    "Savory",
                    "Schroeder America",
                    "Scotsman",
                    "Seco",
                    "Sertek",
                    "Server",
                    "Service Caster",
                    "Service Ideas",
                    "Servolift",
                    "Sharpie",
                    "Shaver - Keen Kutter",
                    "Shortening Shuttle",
                    "Sierra",
                    "Silver King",
                    "Sipromac",
                    "Sirman - Eurodib",
                    "Slicechief",
                    "Sloan",
                    "Somat",
                    "Somerset Industries",
                    "Sonoco Plastics",
                    "Southbend Range",
                    "Speed Queen",
                    "Spring USA",
                    "Stainless Products",
                    "Stajac Industries",
                    "Star",
                    "Stellar Steam",
                    "Sterling Multimixer",
                    "Stero Dishwasher",
                    "Stoelting",
                    "Structural Concepts",
                    "Sunkist",
                    "Supera",
                    "Superior Cmcrl Coolers",
                    "Sure Shot-AC Dispensing",
                    "System 4",
                    "T&S Brass",
                    "Taconic",
                    "Tafco",
                    "Taylor Precision",
                    "Thermal Engineering",
                    "ThermalRite Blast Chiller",
                    "Thermo-Kool",
                    "Thermodyne",
                    "Thunderbird",
                    "Tomlinson",
                    "Town Food Service",
                    "Traex",
                    "Trane",
                    "Traulsen",
                    "Tri-Star Manufacturing",
                    "TRUE",
                    //"True Manufacturing Cross",
                    "Tucker",
                    //"Tundra",
                    "Turbo Air",
                    "Turbochef",
                    "U S Cooler",
                    "Uline",
                    "Ultrafryer",
                    "Unimac",
                    "United - Eurodib",
                    "Univex",
                    "Update International",
                    "Varimixer",
                    "Victory",
                    "Viking Commercial",
                    "Vistawall",
                    "Visvardis",
                    "Vollrath",
                    "Vulcan Hart",
                    "Wa Brown And Sons",
                    "Wascomat",
                    "Waste King",
                    "Wells",
                    "Whirlpool",
                    "Wilbur Curtis",
                    "Winston",
                    "Wisco",
                    "Wittco",
                    "World Dryer",
                    "Wunder-Bar",
                    "Yamato",
                    "Zesto",
                    "Zojirushi",
                    "Zumex",
                    "Zummo",
                    "Zurn",
                    "Zyliss",
                    "3M",
                    "3M Supplies"
            };

    @Test
    public void countParts() {
        homePage.openHomePage();
        homePage.clickOnShopByManufacturerLink();

        for (int i = 0; i <= manufactuters.length - 1; i++) {
            //System.out.print(manufactuters[i] + "  ");

                StopWatch pageLoad = new StopWatch();
                manufacturerLandingPage.clickOnManufactureLink(manufactuters[i]);
                pageLoad.start();
            if (manufacturerLandingPage.getTemplate().contains("searchListPage")) {
                System.out.print(manufactuters[i] + "," + searchPage.getPartsCount() + "," + searchPage.getModelCount() + ",");
                pageLoad.stop();
                //Get the time
                long pageLoadTime_ms = pageLoad.getTime();
                System.out.println(pageLoadTime_ms);
                homePage.clickOnShopByManufacturerLink();
            } else {
                System.out.println(manufactuters[i] + "," + "0,0,0");
                homePage.clickOnShopByManufacturerLink();
            }


        }
    }
}
