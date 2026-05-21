<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Simple Dictionary | Modern UI</title>
    <!-- Nhúng font chữ Inter cho hiện đại -->
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600;700&display=swap" rel="stylesheet">
    <style>
        :root {
            --primary-color: #4f46e5;
            --primary-hover: #4338ca;
            --bg-gradient: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
            --text-main: #1f2937;
            --text-muted: #6b7280;
            --card-bg: #ffffff;
            --error-color: #ef4444;
            --success-color: #10b981;
            --shadow: 0 10px 25px -5px rgba(0, 0, 0, 0.1), 0 8px 10px -6px rgba(0, 0, 0, 0.1);
        }

        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        body {
            font-family: 'Inter', sans-serif;
            background: var(--bg-gradient);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 20px;
            color: var(--text-main);
        }

        .container {
            width: 100%;
            max-width: 500px;
            background: var(--card-bg);
            padding: 2.5rem;
            border-radius: 20px;
            box-shadow: var(--shadow);
            transition: transform 0.3s ease;
        }

        h2 {
            font-size: 1.8rem;
            font-weight: 700;
            text-align: center;
            margin-bottom: 2rem;
            color: var(--primary-color);
            letter-spacing: -0.025em;
        }

        .search-form {
            display: flex;
            flex-direction: column;
            gap: 12px;
        }

        .input-group {
            position: relative;
        }

        input[type="text"] {
            width: 100%;
            padding: 14px 20px;
            font-size: 1rem;
            border: 2px solid #e5e7eb;
            border-radius: 12px;
            outline: none;
            transition: all 0.2s ease;
            font-family: inherit;
        }

        input[type="text"]:focus {
            border-color: var(--primary-color);
            box-shadow: 0 0 0 4px rgba(79, 70, 229, 0.1);
        }

        button {
            background-color: var(--primary-color);
            color: white;
            padding: 14px;
            border: none;
            border-radius: 12px;
            font-size: 1rem;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.2s ease;
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 8px;
        }

        button:hover {
            background-color: var(--primary-hover);
            transform: translateY(-1px);
            box-shadow: 0 4px 12px rgba(79, 70, 229, 0.2);
        }

        button:active {
            transform: translateY(0);
        }

        hr {
            margin: 2rem 0;
            border: 0;
            border-top: 1px solid #f3f4f6;
        }

        .result-container {
            animation: fadeIn 0.4s ease-out;
        }

        .result-box {
            background-color: #f8fafc;
            padding: 1.5rem;
            border-left: 4px solid var(--success-color);
            border-radius: 8px;
        }

        .result-title {
            font-size: 0.875rem;
            text-transform: uppercase;
            font-weight: 600;
            color: var(--text-muted);
            margin-bottom: 8px;
        }

        .word-display {
            font-size: 1.25rem;
            font-weight: 700;
            color: var(--primary-color);
            margin-bottom: 4px;
        }

        .meaning-display {
            font-size: 1.1rem;
            color: var(--text-main);
            line-height: 1.5;
        }

        .error-message {
            background-color: #fef2f2;
            color: var(--error-color);
            padding: 1rem;
            border-radius: 10px;
            text-align: center;
            font-weight: 500;
            border: 1px solid #fee2e2;
            animation: shake 0.4s ease-in-out;
        }

        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(10px); }
            to { opacity: 1; transform: translateY(0); }
        }

        @keyframes shake {
            0%, 100% { transform: translateX(0); }
            25% { transform: translateX(-5px); }
            75% { transform: translateX(5px); }
        }

        /* Responsive */
        @media (max-width: 480px) {
            .container {
                padding: 1.5rem;
            }
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Từ điển Anh - Việt</h2>

    <!-- GIỮ NGUYÊN FORM LOGIC CỦA BẠN -->
    <form action="/search" method="post" class="search-form">
        <div class="input-group">
            <input type="text" name="word" placeholder="Nhập từ cần tra (vd: hello, book...)" required autocomplete="off">
        </div>
        <button type="submit">
            <svg width="20" height="20" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"></path>
            </svg>
            Tra cứu ngay
        </button>
    </form>

    <hr>

    <!-- Hiển thị nếu tìm thấy từ -->
    <c:if test="${not empty result}">
        <div class="result-container">
            <div class="result-box">
                <div class="result-title">Kết quả tra cứu</div>
                <p class="word-display">${word}</p>
                <p class="meaning-display">${result}</p>
            </div>
        </div>
    </c:if>

    <!-- Hiển thị nếu không tìm thấy -->
    <c:if test="${not empty message}">
        <div class="error-message">
                ${message}
        </div>
    </c:if>
</div>

</body>
</html>