const { defineConfig } = require('@vue/cli-service')

module.exports = {
  devServer: {
    port: 8081,
    proxy: {
      '^/api/': {
        target: 'http://localhost:8080'
      }
    }
  },
  transpileDependencies: true,
  outputDir: 'target/dist',
  assetsDir: 'static',
}