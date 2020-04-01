FROM node:latest

WORKDIR /var/www

COPY package.json /var/www/package.json
RUN npm install

RUN npm install -g @angular/cli
COPY . /var/www

# start app
CMD ng serve --host 0.0.0.0
EXPOSE 4200 
