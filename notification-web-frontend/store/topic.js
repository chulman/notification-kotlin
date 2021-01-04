export const state = () => ({
  selectedTopic: []
});

export const getters = {
  getSelectedTopic: (state) => {
    return state.selectedTopic;
  },
  findFirstSelectedTopic: (state) => {
    if(state.selectedTopic.length === 0) {
      return ''
    }
    return state.selectedTopic[0]
  }
};

export const mutations = {
  setSelectedTopic(state, selectedTopics) {
    state.selectedTopic = selectedTopics;
  }
};

export const actions = {
  async getAll({commit, dispatch, state, getters}, url) {
    const response = await this.$http.$get(url);
    console.log(`get topic list size = ${response.length}`)
    return response;
  }
};
