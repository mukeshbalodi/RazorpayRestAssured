# 🔐 Razorpay API Automation with Rest Assured

This project automates the testing of **Razorpay's Payment APIs** using **Java, Rest Assured**, and **TestNG**. It demonstrates real-world **payment flow validation** in Razorpay sandbox environment.

---

## 📌 Features Covered

- ✅ Create Order  
- ✅ Get Order by ID  
- ✅ Create Payment Link  
- ✅ Cancel Payment Link  
- ✅ List All Orders  



## 🛠️ Tech Stack

| Tool/Tech        | Purpose                       |
|------------------|-------------------------------|
| Java             | Programming Language          |
| Rest Assured     | API Automation                |
| TestNG           | Test Framework                |
| Maven            | Build & Dependency Mgmt       |
| Eclipse IDE      | Code Editor                   |
| Git + GitHub     | Version Control               |

## 📂 Project Structure
<pre> project-root/ ├── src/ │ └── test/ │ ├── java/ │ │ ├── org/ │ │ │ └── Mukesh/ │ │ │ └── MyrestAssured/ │ │ │ ├── BasicCRUD.java │ │ │ └── TestNetwork.java │ │ ├── razorpayapi/ │ │ │ ├── CreateOrderTest.java │ │ │ ├── CreatePaymentLinkTest.java │ │ │ └── CancelPaymentLinkTest.java │ │ └── util/ │ │ ├── ConfigReaderUtil.java │ │ └── PayloadUtil.java │ └── resources/ │ ├── payload/ │ │ ├── createOrderPayload.json │ │ └── createPaymentPayload.json │ └── secrets.properties └── pom.xml </pre>


org.Mukesh.MyrestAssured/` → Basic CRUD and network check tests (e.g., reqres.in)
- `razorpayapi/` → All Razorpay sandbox automation test cases
- `util/` → Utility classes like config file reader and payload loader
- `resources/payload/` → External JSON payload files for APIs
- `secrets.properties` → Stores Razorpay test API credentials securely

## 📢 Disclaimer

This project is intended **solely for learning and demonstration purposes**.

- All Razorpay API calls are made using **sandbox (test mode) credentials**.
- No real financial transactions are processed.
- API keys used in this project are **test credentials** and have **no monetary access**.
- All customer data, emails, phone numbers used are **mock/test data**.
- This project is **not affiliated with or endorsed by Razorpay**.

Use responsibly. Do not upload real API keys or production data to any public repository.


