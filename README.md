# CAMS
The Camp Application and Management System (CAMs) for NTU SC2002

## Authors
- Jared Pek
- Gokul Ramesh
- Qiang ZhiQin
- Rachel Phuar Yi Ling
- Tan Yoong Ken

## Application

### About
- The CAMs application is a Camp Application and Management System for camps conducted within NTU
- It is a centralised platform for both Students and Staff to view, enrol and manage camps
  - Students can view, register and withdraw from camps, and raise enquiries about camps that are open to them
  - Committee members, who are also students, can reply to enquiries and raise suggestions about camps that they are in charge of
  - Staff members can create, edit and delete camps, and reply to enquiries and suggestions about the camps
- This application was designed and built using the OOP design principles, and adheres to the SOLID principles
- You may view more specific documentation about our implementation via our JavaDoc files
  - View the files by navigating to the 'documentation' directory and opening the html files in your browser

### Documentation
- To view the generate JavaDoc pages, nagivate to the 'documentation' directory of this repository: ```cd <path to documentation>```
- Enter 'index.html' in the command line to open the html file: ```index.html```
- Or open the 'index.html' file using your browser

### Setup
- Install a Java JDK on your machine
- Clone the repository: ```git clone https://github.com/jaredpek/CAMS```

### Running the Application
- To run the application, run the jar file that has been created
  - Navigate to the 'application' directory of this repository: ```cd <path to the application directory>```
  - Run the 'application.sh' script: ```bash application.sh```
  - No other actions required to start the application
- Objects will be automatically initialised via our CSV files provided in the 'data' folder
  - View the CSV files by navgiating to the 'data' directory: ```cd <path to the data directory>```
- Any reports that are generated will be written to the 'reports' folder in the 'application' directory
  - View the generated reports by navgiating to the 'reports' directory: ```cd <path to the reports directory>```

### Shutdown
- Fully exit the application via the user interface (do not use CTRL-C)
  - All objects that are created during runtime will be saved to CSV files for data persistence
  - If CTRL-C is used, objects that are created will not be written to CSV files
