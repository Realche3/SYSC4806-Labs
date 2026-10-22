# AddressBook App
[![Java CI with Maven](https://github.com/Realche3/SYSC4806-Labs/actions/workflows/maven.yml/badge.svg)](https://github.com/Realche3/SYSC4806-Labs/actions/workflows/maven.yml)

**Name:** Mohamed Cherif Bah

**Deployed app:** https://mohamed-cherif-addressbook-4806-f6e4gdeqhegzbudn.westus-01.azurewebsites.net

A Spring Boot address book app with a REST API (Spring Data REST) and a Thymeleaf view.
It is built and tested on every push with GitHub Actions and deployed to Azure.

## Try it
Open the home page: https://mohamed-cherif-addressbook-4806-f6e4gdeqhegzbudn.westus-01.azurewebsites.net

1. Click **Create new address book**. It appears in the table, listed by its id.
2. Click the id to open that address book.
3. Fill in the form and click **Add buddy**. You're redirected back to the same page, and the new buddy is listed.

The app uses an in-memory database, so it starts empty and the data resets whenever the app restarts.

The REST API (Spring Data REST) is still available. The requests for it are in `requests-azure.http` (Azure) and `requests.http` (local).

> **Note for TAs:** Chrome may show a "Dangerous" / "Not secure" warning on this site.
> This is my own course project (a plain Spring Boot app on a new azurewebsites.net address),
> and it contains no login or personal data, so it should be safe to continue.
> If your browser blocks it, click "Details" and then "Visit this site", or open it in another browser such as Edge or Firefox.