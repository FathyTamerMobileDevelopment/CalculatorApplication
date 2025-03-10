# Calculator App
![image](https://github.com/user-attachments/assets/283efcc0-ad40-4441-802c-5e656b8aceb9)

A simple, elegant, and responsive calculator application built with Kotlin for Android. This app provides basic arithmetic operations with a clean user interface and a custom animated splash screen.

---

## Table of Contents
1. [Overview](#overview)
2. [Features](#features)
3. [Screenshots](#screenshots)
4. [Technologies Used](#technologies-used)
5. [Installation](#installation)
6. [Usage](#usage)
7. [Project Structure](#project-structure)
8. [Contributing](#contributing)
9. [License](#license)
10. [Contact](#contact)

---

## Overview

The Calculator App is a lightweight Android application designed to perform basic arithmetic operations (addition, subtraction, multiplication, and division). It features a responsive layout that adapts to various screen sizes and includes a custom splash screen with a fade-in animation. The app is built using modern Android development practices, including Kotlin, View Binding, and ConstraintLayout.

This project is ideal for beginners learning Android development or anyone looking for a simple calculator app with a polished UI.

---

## Features

- **Basic Arithmetic Operations**: Supports addition (+), subtraction (-), multiplication (×), and division (÷).
- **Persistent Expression Display**: Shows the full calculation (e.g., "5 + 3 = 8") with blue-colored operators for better readability.
- **Responsive Design**: Adapts to different screen sizes using percentage-based layouts and horizontal chains in ConstraintLayout.
- **Custom Splash Screen**: Displays a logo and app name with a fade-in animation for 2 seconds before transitioning to the main calculator.
- **Clear and Backspace**: Includes an "AC" button to reset the calculator and a "⌫" button to delete the last input.
- **Customizable Icon**: Uses a custom app icon configurable via the manifest.

---

## Screenshots

| Splash Screen | Main Calculator |
|---------------|-----------------|
| ![Splash Screen](https://github.com/user-attachments/assets/85a66fa1-d4b5-4f8c-b421-1f634486dd55) | ![Main Calculator](https://github.com/user-attachments/assets/d52a5b0f-7bde-45db-8a69-2055325bcd79) |
| *Note: Features the **FathyTamer** logo, designed using Figma.* | *Note: Designed using Figma for a clean and responsive UI.* |
---

## Technologies Used

- **Language**: Kotlin
- **UI Framework**: Android SDK with View Binding
- **Layout**: ConstraintLayout for responsive design
- **Animation**: XML-based animations (fade-in)
- **Tools**: Android Studio
- **Dependencies**: 
  - AndroidX libraries
  - (Optional: SplashScreen API for Android 12+ if used)

---

## Installation

To run the Calculator App locally, follow these steps:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/FathyTamerMobileDevelopment/CalculatorApplication.git
   
2. **Open in Android Studio**:
- Launch Android Studio.
- Select Open an Existing Project and navigate to the cloned folder.
  
3. **Sync Project**:
Sync the project with Gradle files (click "Sync Project with Gradle Files" if prompted).

5. **Run the App**:
Connect an Android device or start an emulator.
Click Run > Run 'app' in Android Studio.


Requirements: Android Studio 4.0+, Android SDK 21+ (min SDK).



# Project Structure

calculator-app/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/calcolator/
│   │   │   │   ├── MainActivity.kt         # Main calculator logic
│   │   │   │   └── SplashScreenActivity.kt # Custom splash screen
│   │   │   ├── res/
│   │   │   │   ├── anim/
│   │   │   │   │   └── fade_in.xml        # Fade-in animation
│   │   │   │   ├── drawable/              # App icon and resources
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_calculator_design.xml # Calculator UI
│   │   │   │   │   └── activity_splash.xml           # Splash screen UI
│   │   │   │   ├── mipmap/                # App icon files
│   │   │   │   ├── values/
│   │   │   │   │   └── themes.xml         # App and splash themes
│   │   │   └── AndroidManifest.xml        # App configuration
│   └── build.gradle                       # App-level build config
├── build.gradle                           # Project-level build config
└── README.md                              # This file

# License
This project is licensed under the MIT License - see the LICENSE file for details.
Note: Create a LICENSE file in your repository if you want to include this.

# Contact
For questions or suggestions, feel free to reach out:

GitHub: FathyTamerMobileDevelopment
Email: Fathytameruix@gmail.com![logo](https://github.com/user-attachments/assets/de564699-998b-446e-ac3f-b82c912e6d0b)

