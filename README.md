# multi machine learning (MML)

The goal of this project is to provide high-level facilities to perform machine learning tasks (e.g classification).
The user "just" has to specify a configuration file (in e.g JSON) with information about the dataset, the predictive variables, etc. 
Then, her specification is compiled in different languages/libraries and can then be executed. 
In a sense, doing machine learning in a declarative way, without fighting with the cryptic details of off-the-self libraries. 

## TO DO
  - [x] composer un groupe de 4 min. (5 max.) et mettre en place un git commun (eg sur Github): m'indiquer par retour de mail la composition du groupe et l'URL du git

  - [x] augmenter les fichiers JSON pour prendre en compte davantage de paramètres (eg séparateur dans le dataset, hyperparamètres) y compris lors de la génération de code en Python et R (étendre ConfigurationML puis implémenter le nécessaire dans generateCode de la classe PythonMLExecutor et de la classe RLanguageMLExecutor)

  - [ ] faire en sorte que le langage cible (Python, R ou Julia) soit spécifié dans le JSON (et non directement dans le code Java comme c'est le cas actuellement)

  - [ ] par défaut, s'il n'y a pas d'arguments à MMLMain, le fichier "mml.json" situé à la racine sera utilisé... si un argument est donné (donc args[0]), alors ce sera pour indiquer un nouveau fichier json à considérer pour la génération/exécution du code

  - [ ] tester "manuellement" votre solution (sur différents ".json" avec différents datasets, variables prédictives, etc.)

   - [ ] [bonus] tester automatiquement votre solution en vous inspirant de MMLPythonTest

   - [ ] [bonus] corriger le "bug" du compilateur R qui ne retourne pas seulement le résultat sur la métrique (eg accuracy), mais aussi le code source et les différents résultats des différentes étapes

## Java implementation

The processing of configuration files and compilers are written in Java. 

### Python

Python 3 should be installed with the pandas and scikit-learn library: 
`pip install -r requirements.txt`

warning: on Windows system, the `python` command can well be `py` 

### R

`R` should be installed with `rpart` library

### Julia

(TODO)

### Docker 

Docker files and images are provided to use MML. 

