# AutoBattler
Projet de poo en JAVA - Licence 1 (S2)

--- 
## Installer git (windows)

Il doit y'avoir des tutos pour ça jpense.
## Comment importer le repo localement ?

- Ouvre une console (celle de VScode si tu veux)
- Pour importer le code de Github sur ton pc, place toi soit dans un grand répertoire `(bureau, documents...)` ou si tu as un dossier `poo` tu peux aussi te placer dedans ! 

> *Mais ne créer pas de dossier spécialement vu que ça se fait tout seul*

Une fois placé et git d'installé, entre la commande suivante : 

```bash
git clone https://github.com/kairo00/AutoBattler.git
```

Normalement un dossier avec tout le code à dû être créé.

> **Essaye de penser à toujours modifier dans ta branche !**
## Avoir son fichier local à jour 
En vrai fait le avant que tu commences a bosser dessus pour ne pas avoir de mauvaise surprise.

```bash
git pull origin main
```

## Aller dans ta branche (pour éviter de modifier le main)

```bash
git checkout nom-de-ta-branche
```

## Ajouter un/des fichiers à commit
(Save bien dans VScode avant).

> Tu choisis les fichiers que tu veux sauvegarder.

```bash
git add fichier.txt
```

Pour ajouter tout le fichiers
```bash
git add .
```

Pour ajouter des fichiers de certains types:
```bash
git add *.java
```


## Comment commit ?
```bash
git commit -m "Infos concernant le commit (fix d'un bug, ce que tu as fait, etc...)"
```

## **Ajouter son travail au** main avec une Pull Request (via GitHub)

Supposons que tu es dans ta branche, si tu n'y es pas fait :

```bash
git checkout nom-de-ta-branche
```

Tu veux ajouter le travail que tu as fais au `main`

Commence par ajouter et commit (rappel ci dessous) : 
```bash
git add .
git commit -m "ouaissss"
```

Il te suffit de push ta branche:

```bash
git push origin ma-branche
```

#### Sur Github :
rafraichit la page et clique sur **“Compare & pull request”**, vérifie et clique sur **“Create pull request”**
et Clique sur **“Merge pull request”**.

Voilà normalement ton code est dans le main !
