FROM nginx:1.18
COPY docker .
RUN chmod  +x /etc/scripts/*
WORKDIR /home/deploy
COPY dist app
ENTRYPOINT ["/etc/scripts/nginx-start.sh"]
