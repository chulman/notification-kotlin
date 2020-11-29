export default function ({store, $http}) {
  $http.onRequest(config => {
    console.log(`${config.method} ${config.url}`);
  });
  $http.onError(error => {
    console.error(error);
  });
}
