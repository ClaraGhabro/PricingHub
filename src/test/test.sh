#! /bin/sh

printf '\nAcces a la liste de tous les competitors et des informations associees\n'
curl http://localhost:8080/competitors/

printf '\nAcces a la liste des noms de tous les competitors\n'
curl http://localhost:8080/competitors/names

printf '\nEnvoie la liste filtrée des competitors et de leurs informations\n'
curl --data "names=auto.leclerc,feuvert.fr&startDate=18/12/2019&endDate=22/12/2019" http://localhost:8080/competitors/filtered

printf '\nAcces a la liste des competitors filtrés et de leurs informations associées\n'
curl http://localhost:8080/competitors/filtered

printf "\n"