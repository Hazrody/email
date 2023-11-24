# email

Ce projet récupère le utilisateur provenant de rabbitmq et envoie un mail.

Les mails apparaissent dans mailhog.

Dans les commandes docker ci-dessous j'ai spécifié les ip pour la configuration avec le projet (Ça fonctionnait pas sans).

**Docker mailhog**: ``docker run -d --name mailhog --ip 172.17.0.3 -p 1025:1025 -p 8025:8025 mailhog/mailhog``

**Docker rabbitmq**: ``docker run -it --rm --name rabbitmq --ip 172.17.0.2 -p 5672:5672 -p 15672:15672 rabbitmq:3-management``

Procédure pour lancer l'environnement:

* Ce placer dans le projet et ouvrir un invite de commande pour lancer ``docker build -t email:tag .``
* Pour l'execution: ``docker run -p 8081:8081 -d email:tag``
* Ouvrir rabbitmq et mailhog pour voir les flux.


