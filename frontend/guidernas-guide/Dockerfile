FROM node:20-alpine
LABEL authors="alvarjaxell"
WORKDIR usr/src/app

COPY package*.json ./
RUN npm install

COPY . .

RUN npm run build

CMD ["npm", "start"]