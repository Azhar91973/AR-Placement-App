# 🛠️ AR Placement App for Android

An Android app that allows users to select a "drill" and place a marker in the real world using ARCore.

---

## 📱 Features

- Drill selection screen with description and tips
- AR camera view with plane detection
- Tap to place a drill marker (red cube) in 3D space
- Uses ARCore and Sceneform (AndroidX-compatible)

---

## 🚀 How to Run the App

### ✅ Prerequisites
- Android Studio (2025.1.2.)
- Physical device with **ARCore support**
  - [Check ARCore-compatible devices](https://developers.google.com/ar/devices)
- ARCore installed on the device (usually auto-installed)
- Minimum SDK: 24 (Android 7.0)

### 🔧 Build & Run Steps
1. Clone this repository or download the ZIP.
2. Open the project in Android Studio.
3. Connect your ARCore-supported device via USB.
4. Run the app (`Shift + F10` or green "Run" button).
5. On the device:
   - Select a drill.
   - Tap **Start AR Drill**.
   - Move the phone to detect a surface.
   - Tap on the floor to place the red cube.

---

## 🧪 Troubleshooting

### ❌ App crashes with "Failed to create AR session"
- Ensure your device supports ARCore.
- Make sure **camera permission** is granted.
- ARCore must be installed on the device.

### ❌ Device not supported
- The app will not run AR features on unsupported devices.
- Use a compatible emulator (Pixel 4+, API 30+ with Google Play) if available.

---
