# Photo Editor Project - Java

## Project Overview

The **Photo Editor Project** is a Java-based application that allows users to perform various image manipulation operations such as loading images, adjusting brightness, converting to grayscale, and saving edited images. The project follows the **Model-View-Controller (MVC)** design pattern:
- **Model**: Handles the image data and the core editing logic.
- **View**: Provides a user interface to display messages and results.
- **Controller**: Manages the user input, processes commands, and updates the model accordingly.

## Features

- **Load Images**: Users can load images from files into the system.
- **Brighten Images**: Users can adjust the brightness of an image.
- **Greyscale Conversion**: Convert images to grayscale or apply specific color components (red, green, blue, luma, intensity, max).
- **Save Images**: Save the modified image back to a file.
- **Undo Commands**: The user can stack and undo commands sequentially.

## Technology Stack

- **Programming Language**: Java
- **Design Pattern**: Model-View-Controller (MVC)
- **User Input**: Command-line input via `Scanner` for controlling the operations

## Installation

To set up and run the application locally:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/mdyer001/Photo_Editor_Project_Java.git
   cd Photo_Editor_Project_Java
