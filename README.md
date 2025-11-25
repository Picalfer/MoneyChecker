# MoneyChecker

[![Kotlin](https://img.shields.io/badge/Kotlin-1.8+-blue.svg?logo=kotlin)](https://kotlinlang.org)
[![Platform](https://img.shields.io/badge/Platform-Android-green.svg?logo=android)](https://www.android.com/)
[![Firebase](https://img.shields.io/badge/Firebase-RealtimeDB-orange.svg?logo=firebase)](https://firebase.google.com/)

Приложение для добавления и отображения списка товаров с использованием Firebase Realtime Database.

## О проекте

Простое приложение, позволяющее сохранять товары с ценами в облачной базе данных и автоматически отображать их в списке. Использует RecyclerView и Realtime Database для динамического обновления данных.

**Основной функционал:**
- Добавление товара (имя + цена)
- Хранение данных в Firebase Realtime Database
- Автоматическое обновление списка через ChildEventListener
- Сортировка элементов по цене
- Отображение списка через RecyclerView

## Технологии

* Kotlin  
* RecyclerView  
* Firebase Realtime Database  
* ChildEventListener  
* ViewBinding / стандартные View  
* LinearLayoutManager
