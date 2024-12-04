const validateRequest = require('../utils/validators');
const bcrypt = require('bcryptjs');

const prisma = require('../prisma/client')

const register = async (req, res, next) => {
  if (!validateRequest(req, res)) return;

  const hashedPassword = await bcrypt.hash(req.body.password, 10);

  try {
    const user = await prisma.user.create({
      data: {
        name: req.body.name,
        email: req.body.email,
        password: hashedPassword,
      }
    })

    const { password, ...userWithoutPassword } = user;
    res.status(201).send({
      success: true,
      message: 'Register successfully',
      data: userWithoutPassword
    });

  } catch (e) {
    next(e);
  }
}

module.exports = { register };