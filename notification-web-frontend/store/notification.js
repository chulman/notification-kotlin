export const actions = {
  async sendNotification({commit, dispatch, state, getters}, payload) {
    const data = await this.$http.post(payload.url, payload.data);
    return data;
  }
};
