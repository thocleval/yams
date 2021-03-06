# Yet Another Music Site

[![Build Status](https://travis-ci.com/tbille/yams.svg?token=ugzKv1u9GPfZ6XxywWez&branch=master)](https://travis-ci.com/tbille/yams)
[![codecov](https://codecov.io/gh/tbille/yams/branch/master/graph/badge.svg?token=f4w2dDZiDz)](https://codecov.io/gh/tbille/yams)

«Yams» (Yet Another Music Site) est un site permettant de fédérer une communauté de passionnés de musique. Le site Yams est composé des grands domaines fonctionnels suivants :

* La gestion des membres de la communauté : 
  * Inscriptions
  * Modification du compte
  * Suppression des membres de la communauté
  * Gestion des lectures : 
    * Chaque membre peut référencer les musiques déjà écoutées
  * Gestion des favoris :
    * Chaque membre peut gérer des favoris (artistes/albums/musiques)
  * Gestion des notes :
    * Chaque membre peut noter les artistes, albums, musiques
  * *[Facultatif]* Gestion Playlist (musiques à écouter)
* La gestion des artistes/albums/musiques/styles musicales : 
  * Ajout
  * Modification
  * Suppression
* *[Facultatif]*
  * Les membres de la communauté peuvent proposer de nouveaux artistes/albums/musiques, 
  * Web radio by style

## Requirements

* Mongodb
* Maven
* Node v7.0.0
* For frontend developer: @angular/cli (`npm install -g @angular/cli`)

## Installer le projet

* `mvn clean install`
* `java -jar backend/target/backend-0.0.1-SNAPSHOT.jar --spring.profiles.active=<PROFILE>`
    * development
    * test
    * production

## Some quality

  * Sonarqube : https://sonarqube.com/dashboard?id=com.ups.yams%3Abackend

## Developpers Team :

  * Thomas Bille
  * Clément Chaumel
  * Valentin Chevalier
  * Adnane Keheli
  
