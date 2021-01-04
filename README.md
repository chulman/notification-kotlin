# notification project

> 프로젝트 구성

| name | classification | description |
|------|---|---|
| notification-api | server | api server for notification publish |
| notification-common | library | common library sets |
| notification-web-frontend | web-frontend | web ui for notification provide |

- 프로젝트는 멀티프로젝트 기반으로 구성됩니다.
- 간단한 프로젝트이므로 domain 및 interface 는 sub project 로 분리하지 않습니다.
- 공통 코드는 common 프로젝트에서 관리합니다. 
- 프론트엔드 코드는 nuxt.js 및 vue framework 기반으로 작성합니다.

### TODO
- [X] push 된 알림을 db에 저장
- [X] topic update 
- [X] notification web project complete
