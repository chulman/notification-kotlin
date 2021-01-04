export const actions = {
  async sendNotification({commit, dispatch, state, getters}, payload) {
    return this.$http.post(payload.url, payload.data);
  }
};
