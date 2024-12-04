/**
 * @swagger
 * components:
 *   schemas:
 *     User:
 *       type: object
 *       required:
 *         - name
 *         - email
 *         - password
 *         - confirmPassword
 *       properties:
 *         id:
 *           type: string
 *           description: The auto-generated id of the user
 *         name:
 *           type: string
 *           description: The name of user
 *         email:
 *           type: string
 *           description: The user email
 *         createdAt:
 *           type: string
 *           format: date
 *           description: The date the user was added
 *         updatedAt:
 *           type: string
 *           format: date
 *           description: The date of user was updated
 *       example:
 *         id: 1
 *         name: Testing user
 *         email: example@mail.com
 *         createdAt: 2020-03-10T04:05:06.157Z
 *         updatedAt: 2020-03-10T04:05:06.157Z
 *     ValidationError:
 *       type: array
 *       items:
 *         type: object
 *         properties:
 *           type:
 *             type: string
 *             description: The type of error
 *             example: field
 *           value:
 *             type: string
 *             description: The value of the field
 *             example: ""
 *           msg:
 *             type: string
 *             description: The error message
 *             example: Name is required
 *       
 */

const express = require('express');

const router = express.Router();
const verifyToken = require('../middlewares/auth');

const registerController = require('../controllers/RegisterController');
const loginController = require('../controllers/LoginController');
const { validateRegister, validateLogin } = require('../utils/validators/auth');

/**
 * @swagger
 * /register:
 *   post:
 *     summary: register new user
 *     tags: [Auth]
 *     requestBody:
 *       required: true
 *       content:
 *         application/json:
 *           schema:
 *             type: object
 *             properties:
 *               name:
 *                 type: string
 *                 description: The name of user
 *               email:
 *                 type: string
 *                 description: The user email
 *               password:
 *                 type: string
 *                 description: The user password
 *               confirmPassword:
 *                 type: string
 *                 description: The user password confirmation
 *     responses:
 *       200:
 *         description: Users successfully registered
 *         content:
 *           application/json:
 *             schema:
 *               type: object
 *               properties: 
 *                 success:  
 *                   type: boolean 
 *                   description: true or false
 *                   example: true
 *                 message:
 *                   type: string
 *                   description: Message of the response
 *                   example: Register successfully
 *                 data:
 *                   type: object  
 *                   $ref: '#/components/schemas/User'
 *       422:
 *          description: Validation Error
 *          content:
 *            application/json:
 *             schema:
 *               type: object
 *               properties:
 *                 success:
 *                   type: boolean 
 *                   description: true or false 
 *                   example: false
 *                 message:
 *                   type: string
 *                   description: Message of the response     
 *                   example: Validation Error
 *                 errors:    
 *                   $ref: '#/components/schemas/ValidationError'
 *       401:
 *          description: Unauthorized
 *          content: 
 *           application/json:
 *            schema:
 *             type: object
 *             properties:
 *               success:
 *                type: boolean
 *                description: true or false
 *                example: false
 *               message: 
 *                type: string
 *                description: Message of the response
 *                example: Invalid password
 *                
 */
router.post('/register', validateRegister, registerController.register);


router.post('/login', validateLogin, loginController.login);

module.exports = router;