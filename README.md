[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/vlo9idtn)
# lab1-wa2025

## RouteAnalyzer

A Kotlin application that computes various statistics given a route and some input parameters.

###
### Running the application
You need to have docker installed on your machine.
Then, from the repository root, build the application with the following command: 
```bash
docker build -t 'image_name' ./RouteAnalyzer
```

The application expects you to mount the folder containing `waypoints.csv` and `custom-parameters.yml` to a specific mount point. Inside the same directory the output file will be created. 
```bash
docker run -v {input_output_path}:/app/evaluation image_name
```
Replace `{input_output_path}` with your own. To use the provided example `evaluation` folder:
```bash
docker run -v ./evaluation:/app/evaluation image_name
```

## RouteGenerator

A React application that allows you to calculate and download routes given a set of geographical points (latitude, longitude), using OpenRouteService.