Summary
---
Meme Stream Application where users can post memes by providing their name, a caption for the meme and the URL for the meme image as input. The page retrieves and displays the latest 100 posted Memes.

This is not a meme generator, but a simple app to pull created memes using their URL and listing them on this page with the user’s name and caption. This project was implemented as a part of Crio.Do's Crio Winter of Doing program Jan 2021 (stage 2 phase B).

Design
---
![](https://github.com/ashu20071/x-meme/blob/master/XMEME_MODULE_BASIC_image_1.png)


How to start the DropWizard application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/DWGettingStarted-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

License
---
Apache License v2
