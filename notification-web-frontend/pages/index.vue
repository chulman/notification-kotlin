<template>
  <div class="temp-container">
    <h1>Testing For Notification</h1>
    <p>
      <em>you can do topic registration and message delivery tests.</em>
    </p>
    <h2>TOPIC</h2>
    <div class="section">
      <h4> search for topic </h4>
      <Topic/>
    </div>
    <h2>Message</h2>
    <div class="section">
      <div class="section__row">
        <input id="message" v-model="message" type="text"
               placeholder="input test message...">
        <div class="inline-button-container">
          <button @click="send('message')">Send</button>
          <button @click="clearInput($event, 'message')">Clear</button>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { mapActions, mapGetters } from 'vuex';

export default {
  data() {
    return {
      message: ''
    };
  },
  computed: {
    ...mapGetters('topic', {
      selectedTopic:'findFirstSelectedTopic'
    }),
  },
  mounted() {},
  methods: {
    ...mapActions('notification', {
      sendNotification: 'sendNotification'
    }),
    send(model) {
      const topic = this.selectedTopic;
      if (topic === '') {
        alert('topic 을 선택해주세요.');
        return;
      }

      const payload = {
        url: '/api/v1/notification/send',
        data: {
          topic,
          message: this[model]
        }
      }
      this.sendNotification(payload)
    },
    clearInput(event, model) {
      event.preventDefault();
      this[model] = '';
    }
  }
};
</script>

<style lang="scss" scoped>
.temp-container {
  padding: 16px;
}

h1 {
  margin-bottom: 1em;
  font-size: 1.36em;
  font-weight: bold;
}

h2 {
  margin-top: 2em;
  font-size: 1.12em;
  font-weight: bold;
}

.section {
  margin-top: 16px;
  min-width: 260px;
  max-width: 800px;

  &__row {
    display: flex;
    margin-top: 8px;

    .order-link {
      margin-left: 16px;
    }

    &--margin {
      margin-top: 12px;
    }

    label {
      width: 72px;
    }

    span {
      margin-bottom: 5px;
    }

    input {
      flex: 1;
      height: 28px;
      background: #fff;
      border: 1px solid #999;
      border-radius: 3px;

      &[type="submit"] {
        width: 100%;
        border: 1px solid #999;
        background: #ddd;
      }
    }

    .inline-button, .inline-button-container {
      flex: 0;
      margin-left: 4px;
      display: flex;
    }

    .inline-button-container button {
      width: 100%;
      margin-left: 8px;
    }

    button {
      flex: 1;
      padding: 0 8px;
      border: 1px solid #999;
      border-radius: 3px;
      min-height: 28px;
      background: #ddd;

      &:active {
        background: #999;
      }
    }
  }
}

.long-text {
  word-break: break-all;
}

a {
  color: #0074D9;
}
</style>
