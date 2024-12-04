const swaggerJsdoc = require('swagger-jsdoc')
const swaggerUi = require('swagger-ui-express')

const options = {
  swaggerDefinition: {
    openapi: '3.0.3',
    info: {
      title: 'Hastra Vani API',
      version: '1.0.0',
      description: 'API Service for Capstone Project',
    },
    servers: [
      {
        url: 'https://hastravani-api-693713901451.asia-southeast2.run.app',
      },
    ],
  },
  apis: ['./routes/*.js']
}

const specs = swaggerJsdoc(options)

module.exports = (app) => {
  app.use('/api-docs', swaggerUi.serve, swaggerUi.setup(specs))
}