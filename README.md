# HastraVani: Bridging Worlds Through Sign Language

![Bangkit 2022 Logo](https://law.uii.ac.id/wp-content/uploads/2021/11/logo-bangkit-2022.png)

HastraVani is an innovative application designed to translate sign language into text. It aims to bridge communication gaps between the hearing-impaired community and the wider population, enabling inclusivity and accessibility in daily interactions.

## Features
- Converts sign language into readable text.
- Supports BISINDO (Bahasa Isyarat Indonesia).
- User-friendly interface.
- Allows word or sentence composition based on detected letters.

---

## Group Information

**Group ID:** C242-PS220

| Student ID       | Name                      | Email                                | Learning Path       | University                              |
|------------------|---------------------------|--------------------------------------|---------------------|-----------------------------------------|
| A263B4KY0248    | Ahnaf Raihan Aziz         | A263B4KY0248@bangkit.academy        | Mobile Development  | Universitas Muhammadiyah Purwokerto    |
| M319B4KXO267    | Aisyah Nurhalimah        | M319B4KXO267@bangkit.academy        | Machine Learning    | Universitas Sumatera Utara             |
| A390B4KY0688    | Aryo Yusuf Kusuma        | A390B4KY0688@bangkit.academy        | Mobile Development  | Universitas Prima Indonesia            |
| C270B4KY1733    | Haris Muzakki Indra      | C270B4KY1733@bangkit.academy        | Cloud Computing     | Universitas Mulia                      |
| M270B4KY2587    | Mohd. Yusri Nasrol       | M270B4KY2587@bangkit.academy        | Machine Learning    | Universitas Mulia                      |
| M806B4KY3487    | Petrus Hemat Siregar     | M806B4KY3487@bangkit.academy        | Machine Learning    | Universitas IBBI                       |
| C319B4KY3965    | Ronaldo Lamganda Batubara| C319B4KY3965@bangkit.academy        | Cloud Computing     | Universitas Sumatera Utara             |

---

## Prerequisites
Ensure your environment meets the following requirements:

1. **System Requirements:**
   - Operating System: Windows/Mac/Linux
   - RAM: 8 GB or higher
   - GPU: Recommended for training neural networks (e.g., NVIDIA)

2. **Software and Libraries:**
   - Python (>= 3.8)
   - Node.js (>= 16)
   - Git

3. **Python Libraries:**
   - TensorFlow (for machine learning)
   - OpenCV (for image processing)
   - Flask (for machine learning backend)
   - Other dependencies listed in `requirements.txt`.
     
---

## Installation Steps

### 1. Clone the Repository
```bash
# Clone the HastraVani repository
git clone https://github.com/mzkki/hastra--vani.git
cd hastra-vani
```

### 2. Install Dependencies
#### Authentication Backend:
```bash
# Navigate to the authentication service directory
cd cc

# Install dependencies
npm install
```

#### Machine Learning Backend:
```bash
# Navigate to the machine learning service directory
cd ml

# Create a virtual environment
python -m venv venv

# Activate the virtual environment
venv\Scripts\activate

# Install required Python libraries
pip install -r requirements.txt
```

#### Mobile Frontend:
```bash
# Open the Kotlin project in Android Studio
```

### 3. Set Up the Database
- Create a database (e.g., PostgreSQL) to store user data.
- Update the database configuration in the `.env` file:
  ```env
  DATABASE_URL="mysql://<<username>>:<<password>>@localhost:<<port>>/<<db_name>>"
  ```

### 4. Train the Machine Learning Model
- Ensure labeled sign language datasets are available.
- Run the training script in the `ml-service` directory:
  ```bash
  python (which jupyter notebook).py
  ```

### 5. Run the Application
#### Start Authentication Backend:
```bash
# Navigate to the auth-service directory
cd cc
npm start
```

#### Start Machine Learning Backend:
```bash
# Navigate to the ml-service directory
cd ml
flask run
```

#### Start Mobile Application:
- Open the Kotlin project in Android Studio.
- Run the application on an emulator or a physical device.

---

## Usage
1. Launch the mobile application on your device.
2. Log in or sign up using the authentication service.
3. Use a webcam or device camera to perform sign language gestures.
4. View the translated text on the mobile app.

---

## Replication Guide

1. **Dataset:**
   - Collect a dataset of sign language images or videos.
   - Use publicly available datasets or create your own with labeled gestures.

2. **Model Training:**
   - Modify and fine-tune the `(model training file).py` script based on your dataset.

3. **Customization:**
   - Update `cc/.env` and `ml/.env` for your specific setup.

---

## Contribution Guidelines
1. Fork the repository.
2. Create a feature branch: `git checkout -b feature-name`.
3. Commit your changes: `git commit -m "Add feature"`.
4. Push to the branch: `git push origin feature-name`.
5. Submit a pull request.

---

## Acknowledgments
- Mentors and peers who supported the development of HastraVani.
- Publicly available sign language datasets.

---

## Contact
For inquiries or collaborations:
- Email: 08harismu@gmail.com
- LinkedIn: [Haris Muzakki](https://www.linkedin.com/in/harismzkki/)

---
