ALTER TABLE funcionarios ADD COLUMN ativo SMALLINT;
UPDATE funcionarios SET ativo = 1;
ALTER TABLE funcionarios ALTER COLUMN ativo SET NOT NULL;