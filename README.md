[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/vlo9idtn)
# lab1-wa2025

## RouteAnalyzer

A kotlin programs that reads a file containing a list of routes and compute 
various statistics.

###
### Running with docker
You need to have docker installed on your machine. Then simply run 
```bash
   docker build -t 'image_name' .
```

###
### Running the application
To run the program you need to pass the path to the evaluation folder containing `waypoints.csv` and `custom-parameters.yml`
```bash
   docker run -v "localpath/evaluation/":/app/evaluation/ "image_name"
```
Replace `localpath` with the path to the evaluation folder on your machine.

<u>**Note: `localpath` MUST be an absolute path.**</u>
An easy way to get the absolute path is to navigate to the folder in terminal and use the `$(pwd)` variable.
