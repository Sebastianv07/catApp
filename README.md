Fullstack Application

Aplicación fullstack para explorar razas de gatos usando The Cat API, desarrollada con Angular, SpringBoot y MongoDB.

Instalación y ejecución

Requisitos
- Node.js 20+
- npm o yarn
- Cuenta en MongoDB Atlas

1. Clonar el repo

git clone https://github.com/Sebastianv07/catApp.git

2. Ejecución del back

cd backend
npm install
mvn spring-boot:run

El backend correrá en 'http://localhost:8080'

3. Ejecución del Front
cd frontend
npm install
ng serve

El frontend correrá en 'http://localhost:4200'

Endpoints

GET  /api/gatos/breeds           - Todas las razas
GET  /api/gatos/breeds/:id       - Raza específica
GET  /api/gatos/search           - Búsqueda de razas
GET  /api/imagenes/imagesbybreedid - Imágenes por raza
POST /api/usuarios/register      - Registro de usuario
POST /api/usuarios/login         - Login de usuario
