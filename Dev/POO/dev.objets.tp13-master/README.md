# dev.objets.tp13 : sérialisation/désérialisation et requetes HTTP

## question 1 : manipuler un fichier JSON

Le format [JSON](https://fr.wikipedia.org/wiki/JavaScript_Object_Notation) 
(JavaScript Object Notation) 
est un format de fichiers textes utilisé pour représenter des objets qui 
dérive de la notation des objets du langage JavaScript. 
Un document JSON est essentiellement un ensemble de paires constituées 
d'une étiquette et d'une valeur ou d'une liste de valeurs. 
Les paires sont placées entres accolades et séparées par des virgules. 
Les valeurs des listes sont placées entre crochets et séparées par des virgules.

Exemple : [exemple.q1](ressources/exemple.json)

Ce fichier présente un objet JSON "matiere" constitué de 3 sous-valeurs : 
`matiere`, `enseignants` et `responsable` ; 
l'élément `enseignants` est un tableau de valeurs, alors que les éléments
`matiere` et `responsable` sont de simple paires clé/valeur.

Ouvrez le fichier avec firefox : vous devriez avoir un affichage plus sympathique.

Pour faciliter la manipulation de données au JSON, nous allons utiliser 
une bibliothèque spécifique qui n'est pas chargée par défaut par Kotlin, 
mais développée par Google : [Gson](https://github.com/google/gson).
Dans le fichier `build.gradle.kts`, ajoutez dans le bloc `dependencies` :


    implementation("com.google.code.gson:gson:2.9.0")


Puis, "rebuilder" le fichier `build.gradle.kts` 
("clic" sur le petit éléphant avec une flèche bleue circulaire, en haut à droite) ; 
cela va downloader/installer la bibliothèque demandée.


Dans le fichier `q1.mainJson.kt`, recopiez le code suivant :

    val nomFichier = "ressources/exemple.q1"
    val reader = FileReader(nomFichier)
    val arbreJson = Gson().fromJson(reader, JsonObject::class.java)
    println(arbreJson)
    // TODO
    reader.close()



L'objet `arbreJson` est un objet de type `JsonObject` représentant 
l'ensemble du fichier JSON chargé en mémoire. On peut naviguer dans 
l'objet Json en utilisant 
l'[API de JsonObject](https://www.javadoc.io/doc/com.google.code.gson/gson/latest/com.google.gson/com/google/gson/JsonObject.html)

Récupérez (et affichez) les éléments suivants :
- le nom de la matière
- le nom du responsable
- le nombre d'enseignants
- l'email du 3ième enseignant
- tous les noms des enseignants


## question 2 : sérialisation/dé-sérialisation

La sérialisation consiste à enregistrer l'état d'un objet/ensemble d'objets afin
de le/les recharger plus tard lors d'un futur lancement de l'application.

Pour mettre en oeuvre la sérialisation, plusieurs solutions sont possible. 
Nous allons mettre en place une sérialisation JSON, c-à-d qu'on va sauvegarder
les objets souhaités au format JSON et ainsi pouvoir les recharger ultérieurement.

Là encore, nous utiliserons la bibliothèque [Gson](https://github.com/google/gson).

Considérez la classe `q2.Message`.

Complétez la methode `serialiser(nomFichier : String)` 
dans `q2.Message` avec le corps suivant :


    val writer = FileWriter(nomFichier)
    Gson().toJson(this, writer)
    writer.flush()
    writer.close()


Dans `q2.Serialiser.kt`, instanciez un objet `Message`, puis sérialisez le.

Complétez maintenant la fonction 
`deserialiserMessage(nomFichier : String) : Message?` avec le corps suivant :


    val reader = FileReader(nomFichier)
    var message = Gson().fromJson(reader, Message::class.java)
    reader.close()
    return message


Dans `q2.Deserialiser.kt`, rechargez l'objet sérialisé précédemment.

Considérez maintenant la classe `q2.Forum`, qui représente
une liste de messages. Permettez de sérialiser/de-sérialiser un forum. Testez.



## Question 3 : requêtes HTTP

Une requête HTTP est tout simplement ce que fait un navigateur web 
(chrome, firefox) quand vous saisissez une URL dans l'espace dédié. 
Le navigateur exécute la requête auprès d'un serveur,
reçoit en réponse, une page web, et enfin, affiche la page web demandée.

Dans le cas d'un programme quelconque, ce sera exactement la même chose.
Nous allons exécuter une requête en utilisant un "client HTTP" particulier
et recevoir une réponse. Souvent, il ne s'agira pas d'une page web, 
mais d'informations renvoyées au format JSON.

Ajoutez au projet une bibliothèque particulière afin d'accéder à un client HTTP.
Dans le fichier `build.gradle.kts`, ajoutez dans le bloc `dependencies` :


    implementation("io.ktor:ktor-client-core:2.0.1")
    implementation("io.ktor:ktor-client-apache:2.0.1")
    implementation("io.ktor:ktor-client-cio:2.0.1")


Dans la fonction `main()` dans `q3.Requete.kt` ajoutez le code suivant :

    val client = HttpClient(CIO)
    var url = "https://www.perdu.com"
    runBlocking {
        val reponse : HttpResponse = client.get(url)
        println(reponse)
        println(reponse.body<String>())
    }

Si vous êtes sur un poste de l'IUT, remplacez le client par le code suivant :

    val client = HttpClient(Apache){
        engine {
            customizeClient {
                setProxy(HttpHost("srv-proxy-etu-2.iut-nantes.univ-nantes.prive", 3128))
            }
        }
    }

Ici on réalise une simple requête, puis on affiche toute la réponse.

Remplacez l'URL considérée par celle-ci :

    
    http://jsonplaceholder.typicode.com/posts/1


Ici, on récupère un fichier JSON.

On peut également récupérer un `JsonObject` afin de pouvoir le parcourir :

    
    val json = JsonParser.parseString(reponse.body<String>()).asJsonObject


Ajoutez à `q2.Message` une fonction `charger(url : String) : Message?`
qui charge l'url, récupère `JsonObject`, puis parcoure
le `JsonObject` pour récupérer les bonnes informations et créer un objet `Message`

L'url http://jsonplaceholder.typicode.com/posts/ renvoie un tableau JSON ;
ajoutez à `q2.Forum`, une méthode `charger()` permettant de charger
tous les posts renvoyés par l'URL dans le forum.

## Question 4 : carnet d'adresses

Considérez les classes `Personne`, `Adresse` et `CarnetAdresse`.

Dans la classe `CarnetAdresse`, 
implémentez les méthodes `serialiser(...)` et
`deserialiser(...)` permettant de sérialiser/de-sérialiser 
un carnet d'adresse ; testez

L'API https://randomuser.me génère des utilisateurs aléatoirement.
Utilisez l'URL suivante :


    https://randomuser.me/api/?nat=fr&noinfo&inc=name,location,email,dob&results=10


pour implémenter la méthode `CarnetAdresse.charger()` qui doit récupérer
10 utilisateurs et les ajouter au carnet d'adresse.
